package com.example.task.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.task.model.popularpeople.PopularPeopleModel
import com.example.task.network.APIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

public class PopularPeopleRepository {

    public var popularPeopleListMutableLiveData: MutableLiveData<PopularPeopleModel>? = null

    var compositeDisposable = CompositeDisposable()


    fun getPopularPeopleListValues( api_key:String, language:String, page:Int): MutableLiveData<PopularPeopleModel> {
        popularPeopleListMutableLiveData = MutableLiveData<PopularPeopleModel>()
        compositeDisposable.add(
            APIClient.getInstance().api
                .popularPeople_List(api_key,language,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response -> popularPeopleListMutableLiveData?.setValue(response)}, {t -> onFailure(t) }))
        return popularPeopleListMutableLiveData as MutableLiveData<PopularPeopleModel>

    }

    private fun onFailure(t: Throwable) {




    }
}