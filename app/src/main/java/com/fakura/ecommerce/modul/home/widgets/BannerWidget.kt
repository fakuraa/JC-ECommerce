package com.fakura.ecommerce.modul.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fakura.ecommerce.model.getBanners
import com.fakura.ecommerce.resource.theme.primaryColor
import com.fakura.ecommerce.resource.theme.whiteColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banner(){
    Column(modifier = Modifier.height(250.dp)) {
        val pagerState = rememberPagerState()

        LaunchedEffect(Unit){
            while (true){
                yield()
                delay(2000)
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                )
            }
        }
        HorizontalPager(
            count = 5,
            state = pagerState,
            // Add 32.dp horizontal padding to 'center' the pages
//            contentPadding = PaddingValues(horizontal = 32.dp),
            modifier = Modifier
                .height(150.dp)
                .weight(1f)
                .fillMaxWidth(),
        ) { page ->
            PagerSampleItem(
                page = page,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = primaryColor,
            inactiveColor = whiteColor
        )
    }
}

@Composable
internal fun PagerSampleItem(
    page: Int,
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Image(
            painter = painterResource(getBanners()[page].image),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.matchParentSize()
        )
    }
}