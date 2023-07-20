package com.nourelden515.gonutswithdonuts.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nourelden515.gonutswithdonuts.R
import com.nourelden515.gonutswithdonuts.ui.main.LocalNavigationProvider
import com.nourelden515.gonutswithdonuts.ui.screens.home.navigateToHome
import com.nourelden515.gonutswithdonuts.ui.theme.Primary60
import com.nourelden515.gonutswithdonuts.ui.theme.Primary80
import com.nourelden515.gonutswithdonuts.ui.theme.Typography
import com.nourelden515.gonutswithdonuts.ui.theme.White

@Composable
fun OnBoardingScreen() {
    val navController = LocalNavigationProvider.current
    OnBoardingContent(
        onClickGetStarted = {
            navController.navigateToHome()
        }
    )
}

@Composable
fun OnBoardingContent(
    onClickGetStarted: () -> Unit,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Primary80),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.align(Alignment.TopCenter),
            painter = painterResource(id = R.drawable.drawable_donuts),
            contentDescription = stringResource(R.string.content_description)
        )
        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(vertical = 46.dp, horizontal = 40.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.gonuts_with_donuts),
                style = Typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 60.dp),
                text = stringResource(R.string.gonuts_with_donuts_description),
                style = Typography.labelLarge,
                color = Primary60
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { onClickGetStarted() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = White
                )
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 12.dp),
                    text = stringResource(R.string.get_started),
                    style = Typography.titleSmall,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOnBoarding() {
    OnBoardingContent {}
}