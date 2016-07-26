package com.ddg.trydatabinding.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.databinding.library.baseAdapters.BR;
import com.ddg.trydatabinding.App;
import com.ddg.trydatabinding.R;
import com.ddg.trydatabinding.api.RequestInterface;
import com.ddg.trydatabinding.databinding.FragmentMainBinding;
import com.ddg.trydatabinding.databinding.ItemDeviceBinding;
import com.ddg.trydatabinding.model.AndroidDTO;
import org.xelevra.architecture.base.BaseFragment;
import org.xelevra.architecture.view.DataBindingRecyclerAdapter;
import java.util.List;
import javax.inject.Inject;
import rx.schedulers.Schedulers;

public class MainFragment extends BaseFragment<ViewDataBinding> {

    @Inject
    RequestInterface api;
    private FragmentMainBinding binding;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        App.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.cardRecyclerView.setHasFixedSize(true);
        binding.cardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        api.getAndroids()
                .observeOn(uiScheduler)
                .subscribeOn(Schedulers.computation())
                .map(androidResponse -> {
                    List<AndroidDTO> list = androidResponse.getAndroidsList();
                    AndroidDTO.setFakeImage(list);
                    return list;
                })
                .subscribe(new ViewSubscription<List<AndroidDTO>>() {
                    @Override
                    public void onNext(List<AndroidDTO> list) {
                        DataBindingRecyclerAdapter<AndroidDTO, ItemDeviceBinding> adapter =
                                new DataBindingRecyclerAdapter<>(list, R.layout.item_device, BR.device);
                        binding.cardRecyclerView.setAdapter(adapter);
                    }
                });
    }
}
