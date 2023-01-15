package com.example.assignmentone.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.assignmentone.R


sealed class NavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: Int
) {
    object Sports : NavItem(R.string.sports, R.drawable.ic_baseline_sports_esports_24, NAV_SPORTS)
    object Casino : NavItem(R.string.casino, R.drawable.ic_baseline_casino_24, NAV_CASINO)
    object Promotions : NavItem(R.string.promotions, R.drawable.ic_baseline_self_improvement_24, NAV_PROMOTIONS)
    object Account : NavItem(R.string.account, R.drawable.ic_baseline_account_circle_24, NAV_ACCOUNT)
}