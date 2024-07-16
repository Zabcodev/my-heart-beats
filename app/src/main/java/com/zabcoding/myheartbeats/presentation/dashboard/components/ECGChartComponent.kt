package com.zabcoding.myheartbeats.presentation.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.extensions.formatToSinglePrecision
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import co.yml.charts.ui.wavechart.WaveChart
import co.yml.charts.ui.wavechart.model.Wave
import co.yml.charts.ui.wavechart.model.WaveChartData
import co.yml.charts.ui.wavechart.model.WaveFillColor
import co.yml.charts.ui.wavechart.model.WavePlotData
import com.zabcoding.myheartbeats.data.network.response.EcgResponse
import com.zabcoding.myheartbeats.presentation.dashboard.model.EcgModel

@Composable
fun ECGChartComponent(
    pointsData: List<EcgModel>,
    modifier: Modifier = Modifier
) {

    val pointsGraph: List<Point> = pointsData.map { ecgData -> Point(ecgData.bpm.toFloat(), ecgData.highPass.toFloat()) }

    val steps = 5

    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .startDrawPadding(48.dp)
        .steps(pointsData.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color(0xFF2978DD))
        .labelAndAxisLinePadding(20.dp)
        .labelData { i -> i.toString() }
        .build()

    val data = WaveChartData(
        wavePlotData = WavePlotData(
            lines = listOf(
                Wave(
                    dataPoints = pointsGraph,
                    waveStyle = LineStyle(color = Color(0xFF057AF9)),
                    selectionHighlightPoint = SelectionHighlightPoint(),
                    shadowUnderLine = ShadowUnderLine(),
                    selectionHighlightPopUp = SelectionHighlightPopUp(),
                    waveFillColor = WaveFillColor(topColor = Color(0xFF1577EF))
                )
            )
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines()
    )

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WaveChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            waveChartData = data
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Latidos por minuto: ${pointsData.last().bpm}",
            fontSize = 18.sp,
            fontWeight = FontWeight.W700,
            color = Color(0xFF1170D8)
        )
    }

}