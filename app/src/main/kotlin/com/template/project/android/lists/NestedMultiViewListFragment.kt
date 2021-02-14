package com.template.project.android.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.project.android.common.Constants
import com.template.project.android.common.dp2Px
import com.template.project.android.common.recyclerview.BindingNestedMultiViewListAdapter
import com.template.project.android.common.recyclerview.BindingNestedUiModel
import com.template.project.android.common.recyclerview.LinearSpaceItemDecoration
import com.template.project.android.databinding.FragmentNestedMultiViewListBinding

class NestedMultiViewListFragment : Fragment() {

    private var binding: FragmentNestedMultiViewListBinding? = null
    private var recyclerAdapterNested = BindingNestedMultiViewListAdapter<BindingNestedUiModel>()
    private val nestedMultiViewListViewModel: NestedMultiViewListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNestedMultiViewListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner  = viewLifecycleOwner
            executePendingBindings()
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        setupObservers()
    }

    private fun getData() {
        nestedMultiViewListViewModel.getNewUiModelsNested()
    }

    private fun setupUi() {
        binding?.rvItems?.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

            if (itemDecorationCount == 0) {
                addItemDecoration(
                    LinearSpaceItemDecoration(
                        spacing = Constants.LIST_ITEMS_SPACING_IN_DP.dp2Px(),
                        orientation = LinearLayoutManager.VERTICAL,
                        spaceFromTop = Constants.LIST_ITEMS_SPACING_IN_DP.dp2Px(),
                        spaceFromBottom = Constants.LIST_ITEMS_SPACING_IN_DP.dp2Px()
                    )
                )
            }

            if (adapter == null) {
                adapter = recyclerAdapterNested
            }
        }
    }

    private fun setupObservers() {
        nestedMultiViewListViewModel.uiModelsNested.observe(viewLifecycleOwner) { newUiModelsNested ->
            recyclerAdapterNested.submitList(newUiModelsNested)
        }
    }
}
