package com.template.project.android.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.project.android.common.Constants.LIST_ITEMS_SPACING_IN_DP
import com.template.project.android.common.dp2Px
import com.template.project.android.common.recyclerview.BindingMultiViewListAdapter
import com.template.project.android.common.recyclerview.BindingUiModel
import com.template.project.android.common.recyclerview.LinearSpaceItemDecoration
import com.template.project.android.databinding.FragmentMultiViewListBinding

class MultiViewListFragment : Fragment() {

    private var binding: FragmentMultiViewListBinding? = null
    private var recyclerAdapter = BindingMultiViewListAdapter<BindingUiModel>()
    private val multiViewListViewModel: MultiViewListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMultiViewListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner  = viewLifecycleOwner
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        setupObservers()
    }

    private fun getData() {
        multiViewListViewModel.getNewUiModels()
    }

    private fun setupUi() {
        binding?.rvItems?.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

            if (itemDecorationCount == 0) {
                addItemDecoration(
                    LinearSpaceItemDecoration(
                        spacing = LIST_ITEMS_SPACING_IN_DP.dp2Px(),
                        orientation = LinearLayoutManager.VERTICAL,
                        spaceFromTop = LIST_ITEMS_SPACING_IN_DP.dp2Px(),
                        spaceFromBottom = LIST_ITEMS_SPACING_IN_DP.dp2Px()
                    )
                )
            }

            if (adapter == null) {
                adapter = recyclerAdapter
            }
        }
    }

    private fun setupObservers() {
        multiViewListViewModel.uiModels.observe(viewLifecycleOwner) { newUiModels ->
            recyclerAdapter.submitList(newUiModels)
        }
    }
}