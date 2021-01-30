package com.template.project.android.lists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.project.android.BR
import com.template.project.android.R
import com.template.project.android.common.Constants.LIST_ITEMS_SPACING_IN_DP
import com.template.project.android.common.dp2Px
import com.template.project.android.common.recyclerview.BindingListAdapter
import com.template.project.android.common.recyclerview.LinearSpaceItemDecoration
import com.template.project.android.databinding.FragmentSimpleListBinding
import com.template.project.android.mock.data.UserListItemUiModel

class SimpleListFragment : Fragment() {

    private var binding: FragmentSimpleListBinding? = null
    private var recyclerAdapter = BindingListAdapter<UserListItemUiModel>(
        bindingVariableId = BR.uiModel,
        itemsLayoutId = R.layout.user_list_item
    )
    private val simpleListViewModel: SimpleListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSimpleListBinding.inflate(inflater, container, false).apply {
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
        simpleListViewModel.getNewUsers()
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
        simpleListViewModel.users.observe(viewLifecycleOwner) { newUsers ->
            recyclerAdapter.submitList(newUsers)
        }
    }
}
