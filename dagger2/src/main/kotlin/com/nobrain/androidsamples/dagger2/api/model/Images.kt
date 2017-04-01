package com.nobrain.androidsamples.dagger2.api.model

import com.nobrain.androidsamples.dagger2.api.model.api.model.Image
import java.util.*

data class Images(var result: Int = 0,
                  var pageCount: Int = 0,
                  var title: String? = null,
                  var totalCount: Int = 0,
                  var description: String? = null,
                  var item: List<Image> = ArrayList<Image>())
