package com.example.notesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentNoteListBinding
import com.google.android.material.chip.Chip

class NoteListFragment : Fragment() {
    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteViewModel by activityViewModels()
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        adapter = NoteAdapter { note ->
            val action = NoteListFragmentDirections
                .actionNoteListFragmentToNoteDetailFragment(note.id)
            view.findNavController().navigate(action)
        }

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
            fabAdd.setOnClickListener {
                val action = NoteListFragmentDirections
                    .actionNoteListFragmentToAddNoteFragment()
                view.findNavController().navigate(action)
            }
        }

        viewModel.getNotes().observe(viewLifecycleOwner) { notes ->
            adapter.submitList(notes)
        }

        setupCategoryFilter()
    }

    private fun setupCategoryFilter() {
        viewModel.getCategories().forEach { category ->
            val chip = Chip(requireContext()).apply {
                text = category
                isCheckable = true
                setOnCheckedChangeListener { _, checked ->
                    if (checked) {
                        viewModel.setCategoryFilter(category)
                    } else {
                        viewModel.setCategoryFilter(null)
                    }
                }
            }
            binding.chipGroup.addView(chip)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
