package com.ddg.trydatabinding.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddg.trydatabinding.AndroidAdapter;
import com.ddg.trydatabinding.App;
import com.ddg.trydatabinding.R;
import com.ddg.trydatabinding.api.RequestInterface;
import com.ddg.trydatabinding.databinding.FragmentMainBinding;
import com.ddg.trydatabinding.model.AndroidDTO;
import com.ddg.trydatabinding.responce.AndroidResponse;
import org.xelevra.architecture.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import rx.schedulers.Schedulers;

public class MainFragment extends BaseFragment<ViewDataBinding> {

    private AndroidAdapter adapter;

    @Inject
    RequestInterface api;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        App.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        adapter = new AndroidAdapter();

        binding.cardRecyclerView.setHasFixedSize(true);
        binding.cardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.cardRecyclerView.setAdapter(adapter);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        api.getAndroids()
                .observeOn(uiScheduler)
                .subscribeOn(Schedulers.computation())
                .subscribe(new ViewSubscription<AndroidResponse>() {
                    @Override
                    public void onNext(AndroidResponse androidResponse) {
                        List<AndroidDTO> list = androidResponse.getAndroidsList();
                        adapter.setAndroids(list);
                    }
                });
    }
}
