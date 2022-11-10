package com.fakura.ecommerce.modul.home.section.body

import android.os.SystemClock
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakura.ecommerce.R
import com.fakura.ecommerce.model.getStuffs
import com.fakura.ecommerce.modul.home.section.component.StuffWidget
import com.fakura.ecommerce.resource.theme.hintColor
import com.fakura.ecommerce.resource.theme.primaryColor
import com.fakura.ecommerce.resource.theme.whiteColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun FlashSaleWidget(){
    Column (modifier = Modifier.background(Color.White).padding(vertical = 12.dp)){
        FlashSaleHeader()
        Spacer(Modifier.height(6.dp))
        FlashSaleBody()
    }
}

@Composable
fun FlashSaleHeader(){
    Row (modifier= Modifier.fillMaxWidth().padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(stringResource(R.string.txt_flash), fontWeight = FontWeight.Bold, color = primaryColor, fontSize = 20.sp)
            Spacer(Modifier.width(4.dp))
            Text(stringResource(R.string.txt_sale), fontWeight = FontWeight.Medium, color = primaryColor, fontSize = 18.sp)
            Spacer(Modifier.width(14.dp))
            Box (Modifier.background(color = Color.Black.copy(0.5f)).padding(2.dp).width(70.dp)
                .clip(RoundedCornerShape(10.dp)), Alignment.Center){
                Text(
                    rememberCountdownTimerState(82400000L),
                    fontWeight = FontWeight.Bold, color = whiteColor, fontSize = 14.sp)
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically ){
            Text(text = stringResource(R.string.txt_see_all), fontWeight = FontWeight.Normal, color = hintColor, fontSize = 14.sp)
            Spacer(Modifier.width(1.dp))
            Image(painter = painterResource(R.drawable.ic_arrow_right),"", modifier = Modifier.size(20.dp))
        }
    }
}

@Composable
fun rememberCountdownTimerState(
    initialMillis: Long,
    step: Long = 1000
): String {
    val timeLeft = remember { mutableStateOf(initialMillis) }
    LaunchedEffect(initialMillis, step) {
        val startTime = SystemClock.uptimeMillis()
        while (isActive && timeLeft.value > 0) {
            // how much time actually passed
            val duration = (SystemClock.uptimeMillis() - startTime).coerceAtLeast(0)
            timeLeft.value = (initialMillis - duration).coerceAtLeast(0)
            delay(step.coerceAtMost(timeLeft.value))
        }
    }
    val secMilSec: Long = 1000
    val minMilSec = 60 * secMilSec
    val hourMilSec = 60 * minMilSec
    val dayMilSec = 24 * hourMilSec
    val hours = (timeLeft.value % dayMilSec / hourMilSec).toInt()
    val minutes = (timeLeft.value % dayMilSec % hourMilSec / minMilSec).toInt()
    val seconds = (timeLeft.value % dayMilSec % hourMilSec % minMilSec / secMilSec).toInt()
    return String.format("%02d : %02d : %02d", hours, minutes, seconds)
}

@Composable
fun FlashSaleBody() {
    LazyRow {
        val list = getStuffs().asReversed().slice(0..5)
        items(items = list ){
            StuffWidget(it,
                it.id == list.first().id ,
                it.id == list.last().id )
        }
    }
}
