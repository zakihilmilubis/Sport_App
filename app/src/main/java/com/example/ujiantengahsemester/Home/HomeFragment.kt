package com.example.ujiantengahsemester.Home

import android.media.MediaCodec.LinearBlock
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ujiantengahsemester.Category
import com.example.ujiantengahsemester.CategoryItemAdapter
import com.example.ujiantengahsemester.GoalsItemAdapter
import com.example.ujiantengahsemester.R
import com.example.ujiantengahsemester.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val listCategory = ArrayList<Category>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentHomeBinding.inflate(inflater,container,false)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGoal.layoutManager = layoutManager

        binding.rvCategory.setHasFixedSize(true)

        listCategory.addAll(getListCategory())
        showRecyclerCategory()

        setListData()
        return binding.root
    }

    private fun showRecyclerCategory() {
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val listCategoryAdapter = CategoryItemAdapter(listCategory)
        binding.rvCategory.adapter = listCategoryAdapter
    }

    private fun getListCategory(): Collection<Category> {
        val imgPhoto = resources.obtainTypedArray(R.array.category_photo)
        val titleCategory = resources.getStringArray(R.array.category_title)

        val listCategory = ArrayList<Category>()
        for(i in titleCategory.indices){
            val category = Category(imgPhoto.getResourceId(i, -1), titleCategory[i])
            listCategory.add(category)
        }
        return listCategory
    }

    private fun setListData() {
        val dataList:ArrayList<String> = ArrayList()

        dataList.add("Loose Weight")
        dataList.add("Gain Weight")
        dataList.add("Body Building")
        dataList.add("Healthy")

        val adater = GoalsItemAdapter(dataList)
        binding.rvGoal.adapter = adater
    }


}