package com.example.courser.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courser.R
import com.example.courser.domain.entity.CourseItemEntity
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun CourseCard(course: CourseItemEntity) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))
    ) {
        Column {
            Box(){

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(114.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
                IconButton(onClick = {},
                    Modifier.padding(top = 8.dp, end = 8.dp).background(shape = CircleShape, color = Color(0x32333A4D))
                    .height(28.dp).width(28.dp).align(Alignment.TopEnd)) {
                    if(course.hasLike){
                        Icon(
                            Icons.Filled.BookmarkBorder,
                            "bookmark",
                            tint = Color.Green,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    else {
                        Icon(
                            Icons.Outlined.BookmarkBorder,
                            "bookmark",
                            tint = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }


                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(bottom = 8.dp, start = 8.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(22.dp)
                            .width(46.dp)
                            .background(shape = CircleShape, color = Color(0x32333A4D))
                    ) {
                        Row (horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.Star, "star", tint = Color.Green, modifier = Modifier.width(10.dp).height(9.58.dp))
                        Text(
                            text = course.rate,
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center
                        )
                    }}

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(22.dp)
                            .padding(start = 4.dp)
                            .background(shape = CircleShape, color = Color(0x32333A4D))
                            .wrapContentWidth()
                    ) {
                        Text(
                            text = course.startDate,
                            Modifier.padding(horizontal = 6.dp),
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                        )
                    }
                }

            }

            Text(
                text = course.title,
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, end = 12.dp, top = 16.dp),
                fontSize = 16.sp
            )

            Text(
                text = course.text,
                color = Color.Gray,
                fontSize = 12.sp,
                maxLines = 2,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 16.dp, end = 12.dp, top = 12.dp)
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("${course.price} ₽", color = Color.White, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.padding(start = 16.dp, end = 12.dp, top = 10.dp), fontSize = 16.sp)
                Text("Подробнее →", color = Color(0xFF00D47E), fontFamily = FontFamily.SansSerif, modifier = Modifier.padding(start = 16.dp, end = 12.dp, top = 10.dp))
            }
        }
    }

}