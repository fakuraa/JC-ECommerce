package com.fakura.ecommerce.modul.home.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakura.ecommerce.model.Stuff
import com.fakura.ecommerce.model.Trend
import com.fakura.ecommerce.model.getStuffs
import com.fakura.ecommerce.model.getTrends
import com.fakura.ecommerce.resource.theme.primaryColor
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

private val data = mutableStateListOf<Stuff>()

@Composable
fun TopProductWidget() {
    data.addAll(getStuffs())
    Column {
        val selectedId = remember { mutableStateOf("1") }
        val chips = remember { mutableListOf<Trend>() }
        chips.addAll(getTrends())

            Text("Top Daily Product",
                fontWeight = FontWeight.Medium,
                color = primaryColor,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            LazyRow {
                items(items = chips){
                    Chips(it.title,it.image,
                        it.id==selectedId.value,Modifier,
                        chips.first() == it, chips.last() == it
                    ) {
                        selectedId.value = it.id
                        data.clear()
                        data.addAll(
                            if(chips.first() != it)
                            getStuffs().filter { stuff ->
                                stuff.category.lowercase().contains(it.title.lowercase())
                            }.toList()
                        else
                            getStuffs()
                        )
                    }
                }
            }
        GridViewsStuff()
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2),
//                contentPadding = PaddingValues(
//                    start = 12.dp,
//                    top = 6.dp,
//                    end = 12.dp,
//                    bottom = 16.dp
//                ),
//                modifier = Modifier.height(350.dp),
//                content = {
//                    items(data.size){i->
//                        StuffWidget(data[i], false, false)
//                    }
//                }
//            )

    }
}

@Composable
fun GridViewsStuff() {
    FlowRow (
        mainAxisSize = SizeMode.Expand,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
        modifier = Modifier.padding(start = 12.dp, end = 24.dp, bottom = 30.dp)
    ){
        data.forEach {
            StuffWidget(it, false, false)
        }
    }
}
