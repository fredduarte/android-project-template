package com.template.project.android.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.project.android.BR
import com.template.project.android.R
import com.template.project.android.common.Constants.LIST_ITEMS_SPACING_IN_DP
import com.template.project.android.common.dp2Px
import com.template.project.android.common.recyclerview.BindingListAdapter
import com.template.project.android.common.recyclerview.LinearSpaceItemDecoration
import com.template.project.android.common.uimodel.ButtonListItemUiModel
import com.template.project.android.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private var recyclerAdapter = BindingListAdapter<ButtonListItemUiModel>(
        bindingVariableId = BR.uiModel,
        itemsLayoutId = R.layout.button_list_item
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
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

        recyclerAdapter.submitList(createButtonListItemUiModels())
    }

    private fun createButtonListItemUiModels(): List<ButtonListItemUiModel> {
        return listOf(createButtonToSimpleList())
    }

    private fun createButtonToSimpleList(): ButtonListItemUiModel {
        return ButtonListItemUiModel(
            text = "SimpleListItemFragment",
            onClicked = { view ->
                view.findNavController().navigate(MainFragmentDirections.mainToSimpleList())
            }
        )
    }
}
