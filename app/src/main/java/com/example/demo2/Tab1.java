package com.example.demo2;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo2.databinding.Tab1DiscoveryBinding;

public class Tab1 extends Fragment {

    private Tab1ViewModel mViewModel;
    private Tab1DiscoveryBinding binding;

    public static Tab1 newInstance() {
        return new Tab1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.tab1_discovery, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Tab1ViewModel.class);
        // TODO: Use the ViewModel
        binding.setViewModel(mViewModel);
        binding.getViewModel().setDataHor();
        binding.getViewModel().setDataSqu();
        binding.getViewModel().setDataCol();
        binding.getViewModel().setDataVideo();
        binding.executePendingBindings();

        mViewModel.dataHor.observe(getViewLifecycleOwner(), data -> {
            CustomViewBinding.bindRecyclerViewAdapter(binding.recyclerView, mViewModel.dataHor);
        });

    }

}