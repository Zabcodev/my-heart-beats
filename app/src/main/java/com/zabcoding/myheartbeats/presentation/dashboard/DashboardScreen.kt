package com.zabcoding.myheartbeats.presentation.dashboard

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import co.yml.charts.common.extensions.isNotNull
import com.zabcoding.myheartbeats.presentation.dashboard.components.DashboardTopComponent
import com.zabcoding.myheartbeats.presentation.dashboard.components.ECGChartComponent
import com.zabcoding.myheartbeats.presentation.dashboard.model.EcgModel

@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {

    val state = dashboardViewModel.state.collectAsState()
    var pointsData: List<EcgModel> = emptyList()

    if (state.value.dataList.isNotEmpty()) {
        pointsData = state.value.dataList
        Log.i("DATALIST", pointsData.toString())
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        val (topBar, ecgDiagram) = createRefs()

        DashboardTopComponent(
            modifier = Modifier
                .constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        if (state.value.data.isNotNull()) {
            ECGChartComponent(
                modifier = Modifier
                    .constrainAs(ecgDiagram) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                pointsData = pointsData
            )
        } else {
            Box(
                modifier = Modifier
                    .constrainAs(ecgDiagram) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Ocurrio un error en la transmisión de datos"
                )
            }
        }
    }
}