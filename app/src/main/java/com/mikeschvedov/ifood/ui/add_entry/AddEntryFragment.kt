package com.mikeschvedov.ifood.ui.add_entry

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mikeschvedov.ifood.R
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import com.mikeschvedov.ifood.data.local_data.hardcoded.FoodArchive
import com.mikeschvedov.ifood.data.local_data.hardcoded.FoodCategory
import com.mikeschvedov.ifood.data.local_data.hardcoded.FoodSaved
import com.mikeschvedov.ifood.databinding.FragmentAddEntryBinding
import com.mikeschvedov.ifood.utils.displayToast
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class AddEntryFragment : Fragment() {

    private var _binding: FragmentAddEntryBinding? = null

    private val binding get() = _binding!!

    private lateinit var addEntryViewModel: AddEntryViewModel

    private var thisItemsCalPer100: Int = 0
    private var  thisItemsCarbsPer100: Int = 0
    private var thisItemsProteinPer100: Int = 0
    private var thisItemsFatsPer100: Int = 0

    private var thisItemsCalPerUnit: Int = 0
    private var thisItemsCarbsPerUnit: Int = 0
    private var thisItemsProteinPerUnit: Int = 0
    private var thisItemsFatsPerUnit: Int = 0

    var selectedImageID: Int = 0
    var itemCountedasUnit: Boolean = false
    var itemCategory: FoodCategory = FoodCategory.DEFAULT

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /* ViewModel */
        addEntryViewModel =
            ViewModelProvider(this).get(AddEntryViewModel::class.java)

        /* Binding */
        _binding = FragmentAddEntryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Add the date we want to add entry to, on the save button
        val day =arguments?.getInt("day") ?: 0
        val month= arguments?.getInt("month") ?: 0
        val year = arguments?.getInt("year") ?: 0
        val addToDate = "$day/$month/${year.toString().drop(2)}"
        binding.buttonSave.text = "הוסף ל-${addToDate}"

        // Creating the list Adapter
        val listAdapter: ArrayAdapter<FoodSaved> = ArrayAdapter(
            requireContext(),
            R.layout.simple_list_item_custom,
            FoodArchive.foodDataList)

        binding.apply {
            // Attaching our adapter to the list view xml
            listviewXml.adapter = listAdapter

            // Setting the list Adapter
            searchviewXml.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                // Runs when the user presses enter inside the search view
                override fun onQueryTextSubmit(query: String?): Boolean {
                    searchviewXml.clearFocus()
                    // We check if the one of those name matches the query
                    //  if (FoodArchive.foodDataList.contains(query)) {
                    //       listAdapter.filter.filter(query)
                    //  }
                    return false
                }

                // Runs each time there is a change inside the search view
                override fun onQueryTextChange(query: String?): Boolean {
                    listAdapter.filter.filter(query)
                    // if the query is empty hide the unit/grams layout
                    if(query.isNullOrEmpty()){
                        displayCalculationByUnit.visibility = View.GONE
                        displayCalculationByWeight.visibility = View.GONE
                        unitsEdittextXml.text.clear()
                        gramsEdittextXml.text.clear()
                        listviewXml.visibility = View.VISIBLE
                    }
                    return false
                }
            })

            // When we click on an item it will appear in the search view
            listviewXml.setOnItemClickListener { _, _, position, _ ->
                // We set the text to the search view
                searchviewXml.setQuery(listAdapter.getItem(position).toString(), false);
                // We hide the list after clicking on the item
                listviewXml.visibility = View.GONE
                // We store our selected item's core calories
                thisItemsCalPer100 = listAdapter.getItem(position)?.calPer100gr ?: 0
                // Macros
                thisItemsCarbsPer100 = listAdapter.getItem(position)?.carbPer100gr ?: 0
                thisItemsProteinPer100 = listAdapter.getItem(position)?.proteinPer100gr ?: 0
                thisItemsFatsPer100 = listAdapter.getItem(position)?.fatPer100gr ?: 0
                // We store our selected item's image
                selectedImageID = listAdapter.getItem(position)?.imageID ?: 0
                // We store our selected item's category
                itemCategory = listAdapter.getItem(position)?.category ?: FoodCategory.DEFAULT
                // We set it in our textview
                itemsCaloriesPer100Xml.text = thisItemsCalPer100.toString()
                // We check if the item is counted as unit (setting the class scope variable)
                itemCountedasUnit = (listAdapter.getItem(position)?.asUnit == true)
                // If our item is counted by unit ("asUnit" = true)
                if (itemCountedasUnit) {
                    // Then store our selected item's perUnit calories
                    thisItemsCalPerUnit = listAdapter.getItem(position)?.caloriesPerUnit ?: 0
                    // Settings Macros
                    thisItemsCarbsPerUnit = listAdapter.getItem(position)?.carbPerUnit ?: 0
                    thisItemsProteinPerUnit = listAdapter.getItem(position)?.proteinPerUnit ?: 0
                    thisItemsFatsPerUnit = listAdapter.getItem(position)?.fatPerUnit ?: 0
                    // Show the by unit input section
                    displayCalculationByUnit.visibility = View.VISIBLE
                    // We display the cal per unit in our textview
                    itemCaloriesPerUnitXml.text = thisItemsCalPerUnit.toString()
                    // Hide by weight (maybe was displayed just a moment ago)
                    displayCalculationByWeight.visibility = View.GONE
                } else {
                    displayCalculationByWeight.visibility = View.VISIBLE
                    // Hide by unit (maybe was displayed just a moment ago)
                    displayCalculationByUnit.visibility = View.GONE
                }
            }
            //TODO combin both edit text - not reason to keep both
            /*-------------------------------Units EDIT TEXT--------------------------*/
            // When we type something in the edit text the total calories will update in real time

            unitsEdittextXml.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(
                    s: CharSequence, start: Int, before: Int,
                    count: Int
                ) {
                    if (unitsEdittextXml.text.isNotEmpty()) {
                        val caloriesPerUnit = thisItemsCalPerUnit
                        val unitInput = unitsEdittextXml.text.toString().toInt()
                        totalCaloriesXmlByUnit.text = (unitInput * caloriesPerUnit).toString()
                    } else {
                        totalCaloriesXmlByUnit.text = "0"
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {}
            })

            /*-------------------------------Grams EDIT TEXT--------------------------*/
            // When we type something in the edit text the total calories will update in real time
            gramsEdittextXml.addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(
                    s: CharSequence, start: Int, before: Int,
                    count: Int
                ) {
                    if (gramsEdittextXml.text.isNotEmpty()) {
                        val caloriesPerGram = thisItemsCalPer100.toDouble() / 100
                        val gramInput = gramsEdittextXml.text.toString().toInt()
                        totalCaloriesXml.text =
                            (caloriesPerGram * gramInput).roundToInt().toString()
                    } else {
                        totalCaloriesXml.text = "0"
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int, count: Int,
                    after: Int
                ) {
                }

                override fun afterTextChanged(s: Editable) {}
            })

            /* ------------------------------Clicking on the save button------------------------- */
            buttonSave.setOnClickListener {
                // if we deal by grams
                val insertedGrams: String = gramsEdittextXml.text.toString()
                // if we deal by unit
                val insertedUnits: String = unitsEdittextXml.text.toString()

                // -- BY UNIT -- //
                if (itemCountedasUnit) {
                    if (isValidInput(insertedUnits)) {
                        val itemName = searchviewXml.query.toString()
                        val calories = insertedUnits.toInt() * thisItemsCalPerUnit
                        val carbs =  insertedUnits.toInt() * thisItemsCarbsPerUnit
                        val protein = insertedUnits.toInt() * thisItemsProteinPerUnit
                        val fats =  insertedUnits.toInt() * thisItemsFatsPerUnit
                        val imageId = selectedImageID
                        // Sending entry to view model
                        addEntryAndGoBackHome(
                            itemName = itemName,
                            calories = calories,
                            carbs = carbs,
                            protein = protein,
                            fats = fats,
                            imageId = imageId,
                            gramsOrUnit = insertedGrams,
                            itemCategory = itemCategory
                        )
                    } else {
                        requireContext().displayToast("יש להכניס כמות תקינה")
                    }
                // -- BY GRAMS -- //
                } else {
                    if (isValidInput(insertedGrams)) {
                        val itemName = searchviewXml.query.toString()
                        val calories =
                            calculateFinalCalories(insertedGrams.toInt(), thisItemsCalPer100)
                        val carbs = calculateFinalCarbs(insertedGrams.toInt(), thisItemsCarbsPer100)
                        val protein = calculateFinalProtein(insertedGrams.toInt(), thisItemsProteinPer100)
                        val fats = calculateFinalFats(insertedGrams.toInt(), thisItemsFatsPer100)
                        val image = selectedImageID
                        // Sending entry to view model
                        addEntryAndGoBackHome(
                            itemName = itemName,
                            calories = calories,
                            carbs = carbs,
                            protein = protein,
                            fats = fats,
                            imageId = image,
                            gramsOrUnit = insertedGrams,
                            itemCategory = itemCategory
                        )
                        }
                    else {
                        requireContext().displayToast("יש להכניס משקל תקין")
                    }
                }
            }
        }

        return root
    }



    private fun addEntryAndGoBackHome(
        itemName: String,
        calories: Int,
        carbs: Int,
        protein: Int,
        fats: Int,
        imageId: Int,
        gramsOrUnit: String,
        itemCategory: FoodCategory
    ) {

        // Get current time and date from bundle sent
        val hour = arguments?.getInt("hour") ?: 0
        val day = arguments?.getInt("day") ?: 0
        val month = arguments?.getInt("month") ?: 0
        val year = arguments?.getInt("year") ?: 0

        // We convert the imageId to get the name of the resource (id's are always changing so we should not save them)
        // R.id.onion   =>  we only save onion
        val imageResourceName  = resources.getResourceEntryName(imageId)

        // Create new entry
        val newEntry = FoodEntry(
            foodName = itemName,
            calories = calories,
            carbs = carbs,
            protein = protein,
            fats = fats,
            gramsOrUnit = gramsOrUnit, //This has no use, it is only for extra info
            imageName = imageResourceName,
            hour = hour,
            day = day,
            month = month,
            year = year,
            itemCategory = itemCategory
        )
        addEntryViewModel.addNewEntryToDB(newEntry)
        // Clear the query and the edit texts
        binding.searchviewXml.setQuery("", false)
        binding.unitsEdittextXml.text.clear()
        binding.gramsEdittextXml.text.clear()

        // Go back home
        findNavController().navigate(R.id.action_AddEntryFragment_to_HomeFragment)
    }

    private fun calculateFinalCalories(inputGrams: Int, thisItemsCalPer100: Int): Int {
        // We convert out calories into a Double for the sake of division
        val tempCal: Double = thisItemsCalPer100.toDouble()
        // We divide the calories by 100 and multiply by the given Grams
        return ((tempCal / 100) * inputGrams).toInt()
    }

    private fun calculateFinalCarbs(insertedGrams: Int, thisItemsCarbsPer100: Int): Int {
        val tempCarbs: Double = thisItemsCarbsPer100.toDouble()
        return ((tempCarbs / 100) * insertedGrams).toInt()
    }

    private fun calculateFinalProtein(insertedGrams: Int, thisItemsProteinPer100: Int): Int {
        val tempProtein: Double = thisItemsProteinPer100.toDouble()
        return ((tempProtein / 100) * insertedGrams).toInt()
    }

    private fun calculateFinalFats(insertedGrams: Int, thisItemsFatsPer100: Int): Int {
        val tempFats: Double = thisItemsFatsPer100.toDouble()
        return ((tempFats / 100) * insertedGrams).toInt()
    }
    private fun isValidInput(value: String): Boolean {
        // If the vale is not empty and bigger than 0 return true
        return value != "" && value.toInt() > 0
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}