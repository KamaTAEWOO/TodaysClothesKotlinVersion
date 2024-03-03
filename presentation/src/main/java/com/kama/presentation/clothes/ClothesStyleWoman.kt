package com.kama.presentation.clothes

import com.kama.design.R

internal class ClothesStyleWoman {

    companion object {
        @Volatile
        private var instance: ClothesStyleWoman? = null

        fun getInstance(): ClothesStyleWoman {
            return instance ?: synchronized(this) {
                instance ?: ClothesStyleWoman().also { instance = it }
            }
        }
    }

    //4(),5(),9(),12(),17(),20(),23(),28()
    // TODO : 댄디 스타일.
    // TODO : 여자  더위많이탐 댄디 4도
    var BAD4 = intArrayOf(
        R.drawable.w_dandy_pinksweatshirt,
        R.drawable.w_dandy_overshirt,
        R.drawable.w_dandy_cnecshirt,
        R.drawable.w_dandy_longpadding,
        R.drawable.w_dandy_shorpadding,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants,
        R.drawable.w_dandy_blackpants,
        R.drawable.w_dandy_wideslacks
    )
    var txt_BAD4 = arrayOf(
        "두꺼운 셔츠", "두꺼운 셔츠", "두꺼운 셔츠",
        "롱패딩", "숏패딩", "",
        "기모 슬랙스", "기모 청바지", "기모 슬랙스"
    )

    // 여자  더위많이탐 댄디 5도
    var BAD5 = intArrayOf(
        R.drawable.w_dandy_pinksweatshirt,
        R.drawable.w_dandy_overshirt,
        R.drawable.w_dandy_cnecshirt,
        R.drawable.w_dandy_longpadding,
        R.drawable.w_dandy_shorpadding,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants,
        R.drawable.w_dandy_blackpants,
        R.drawable.w_dandy_greenskirt
    )
    var txt_BAD5 = arrayOf(
        "두꺼운 셔츠", "두꺼운 셔츠", "두꺼운 셔츠",
        "롱패딩", "숏패딩", "",
        "기모 슬랙스", "기모 청바지", "두꺼운 스커트+스타킹"
    )

    // 여자  더위많이탐 댄디 9도
    var BAD9 = intArrayOf(
        R.drawable.w_dandy_navyneat,
        R.drawable.w_dandy_overshirt,
        R.drawable.w_dandy_pinksweatshirt,
        R.drawable.w_dandy_blackcoat,
        R.drawable.w_dandy_shorpadding,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants,
        R.drawable.w_dandy_longskirt,
        R.drawable.w_dandy_blackpants
    )
    var txt_BAD9 = arrayOf(
        "두꺼운 니트", "두꺼운 셔츠", "두꺼운 스웨터",
        "두꺼운 코트", "숏패딩", "",
        "두꺼운 슬랙스", "두꺼운 스커트+스타킹", "두꺼운 청바지"
    )

    // 여자  더위많이탐 댄디 12도
    var BAD12 = intArrayOf(
        R.drawable.w_dandy_navyneat,
        R.drawable.w_dandy_overshirt,
        R.drawable.w_dandy_pinksweatshirt,
        R.drawable.w_dandy_blackcoat,
        R.drawable.w_dandy_maccoat,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants,
        R.drawable.w_dandy_longskirt,
        R.drawable.w_dandy_blackpants
    )
    var txt_BAD12 = arrayOf(
        "니트", "셔츠", "스웨터",
        "코트", "코트", "",
        "슬랙스", "긴 스커트", "청바지"
    )

    // 여자  더위많이탐 댄디 17도
    var BAD17 = intArrayOf(
        R.drawable.w_dandy_ttneat, R.drawable.w_dandy_cnecshirt, R.drawable.w_dandy_summerneat,
        R.drawable.w_dandy_beltedjacket, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants, R.drawable.w_dandy_longskirt, R.drawable.w_dandy_blackpants
    )
    var txt_BAD17 = arrayOf(
        "긴 목티", "셔츠", "반팔",
        "자켓", "", "",
        "슬랙스", "긴 스커트", "긴바지"
    )

    // 여자  더위많이탐 댄디 20도
    var BAD20 = intArrayOf(
        R.drawable.w_dandy_cnecshirt, R.drawable.w_dandy_summerneat, R.drawable.ic_xxx,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants, R.drawable.m_dandy_banpants, R.drawable.w_dandy_blackpants
    )
    var txt_BAD20 = arrayOf(
        "셔츠", "얇은 니트", "",
        "", "", "",
        "얇은 슬랙스", "반바지슬랙스", "얇은 긴바지"
    )

    // 여자  더위많이탐 댄디 23도
    var BAD23 = intArrayOf(
        R.drawable.w_dandy_cnecshirt,
        R.drawable.w_dandy_summerneat,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_fatigueshorts,
        R.drawable.w_dandy_greenskirt,
        R.drawable.m_dandy_banslacks
    )
    var txt_BAD23 = arrayOf(
        "셔츠", "얇은 니트", "",
        "", "", "",
        "반바지", "얇은 스커트", "반바지"
    )

    // 여자  더위많이탐 댄디 28도
    var BAD28 = intArrayOf(
        R.drawable.w_dandy_cnecshirt,
        R.drawable.w_dandy_summerneat,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_fatigueshorts,
        R.drawable.w_dandy_greenskirt,
        R.drawable.m_dandy_banslacks
    )
    var txt_BAD28 = arrayOf(
        "긴팔", "셔츠", "반팔",
        "", "", "",
        "반바지", "얇은 스커트", "반바지"
    )

    // 여자  더위적게탐 댄디 4도
    var BBD4 = intArrayOf(
        R.drawable.w_dandy_pinksweatshirt,
        R.drawable.w_dandy_overshirt,
        R.drawable.w_dandy_cnecshirt,
        R.drawable.w_dandy_longpadding,
        R.drawable.w_dandy_shorpadding,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants,
        R.drawable.w_dandy_blackpants,
        R.drawable.w_dandy_wideslacks
    )
    var txt_BBD4 = arrayOf(
        "두꺼운 셔츠", "두꺼운 셔츠", "두꺼운 셔츠",
        "롱패딩", "숏패딩", "",
        "기모 슬랙스", "기모 청바지", "기모 와이어 슬랙스"
    )

    // 여자  더위적게탐 댄디 5도
    var BBD5 = intArrayOf(
        R.drawable.w_dandy_pinksweatshirt,
        R.drawable.w_dandy_overshirt,
        R.drawable.w_dandy_cnecshirt,
        R.drawable.w_dandy_longpadding,
        R.drawable.w_dandy_shorpadding,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants,
        R.drawable.w_dandy_blackpants,
        R.drawable.w_dandy_greenskirt
    )
    var txt_BBD5 = arrayOf(
        "두꺼운 셔츠", "두꺼운 셔츠", "두꺼운 셔츠",
        "롱패딩", "숏패딩", "",
        "기모 슬랙스", "기모 청바지", "두꺼운 스커트+스타킹"
    )

    // 여자  더위적게탐 댄디 9도
    var BBD9 = intArrayOf(
        R.drawable.w_dandy_navyneat,
        R.drawable.w_dandy_overshirt,
        R.drawable.w_dandy_pinksweatshirt,
        R.drawable.w_dandy_blackcoat,
        R.drawable.w_dandy_shorpadding,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants,
        R.drawable.w_dandy_longskirt,
        R.drawable.w_dandy_blackpants
    )
    var txt_BBD9 = arrayOf(
        "두꺼운 니트", "두꺼운 셔츠", "두꺼운 스웨터",
        "두꺼운 코트", "숏패딩", "",
        "두꺼운 슬랙스", "두꺼운 긴스커트", "두꺼운 긴바지"
    )

    // 여자  더위적게탐 댄디 12도
    var BBD12 = intArrayOf(
        R.drawable.w_dandy_navyneat,
        R.drawable.w_dandy_overshirt,
        R.drawable.w_dandy_pinksweatshirt,
        R.drawable.w_dandy_blackcoat,
        R.drawable.w_dandy_maccoat,
        R.drawable.w_dandy_shorpadding,
        R.drawable.w_dandy_beltedpants,
        R.drawable.w_dandy_longskirt,
        R.drawable.w_dandy_blackpants
    )
    var txt_BBD12 = arrayOf(
        "니트", "셔츠", "스웨터",
        "코트", "코트", "숏패딩",
        "슬랙스", "긴 스커트", "긴바지"
    )

    // 여자  더위적게탐 댄디 17도
    var BBD17 = intArrayOf(
        R.drawable.w_dandy_ttneat, R.drawable.w_dandy_cnecshirt, R.drawable.w_dandy_summerneat,
        R.drawable.w_dandy_beltedjacket, R.drawable.w_dandy_blackcoat, R.drawable.w_dandy_maccoat,
        R.drawable.w_dandy_beltedpants, R.drawable.w_dandy_longskirt, R.drawable.w_dandy_blackpants
    )
    var txt_BBD17 = arrayOf(
        "긴 목티", "셔츠", "니트",
        "자켓", "얇은 코트", "얇은 코트",
        "슬랙스", "긴 스커트", "긴바지"
    )

    // 여자  더위적게탐 댄디 20도
    var BBD20 = intArrayOf(
        R.drawable.w_dandy_ttneat, R.drawable.w_dandy_cnecshirt, R.drawable.w_dandy_summerneat,
        R.drawable.w_dandy_beltedjacket, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.w_dandy_beltedpants, R.drawable.m_dandy_banpants, R.drawable.w_dandy_blackpants
    )
    var txt_BBD20 = arrayOf(
        "긴 목티", "셔츠", "반팔",
        "얇은 자켓", "", "",
        "슬랙스", "반바지슬랙스", "긴바지"
    )

    // 여자  더위적게탐 댄디 23도
    var BBD23 = intArrayOf(
        R.drawable.w_dandy_ttneat,
        R.drawable.w_dandy_cnecshirt,
        R.drawable.w_dandy_summerneat,
        R.drawable.w_dandy_beltedjacket,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_fatigueshorts,
        R.drawable.w_dandy_greenskirt,
        R.drawable.w_dandy_banslacks
    )
    var txt_BBD23 = arrayOf(
        "긴 목티", "얇은 셔츠", "반팔",
        "얇은 자켓", "", "",
        "면반바지", "얇은 스커트", "슬랙스 반바지"
    )

    // 여자  더위적게탐 댄디 28도
    var BBD28 = intArrayOf(
        R.drawable.w_dandy_cnecshirt,
        R.drawable.w_dandy_summerneat,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.w_dandy_fatigueshorts,
        R.drawable.w_dandy_greenskirt,
        R.drawable.w_dandy_banslacks
    )
    var txt_BBD28 = arrayOf(
        "셔츠", "반팔", "",
        "", "", "",
        "반바지", "얇은 스커트", "슬랙스 반바지"
    )

    //***************************************************************************************************
    // TODO : 캐주얼 스타일.
    // TODO : 여자  더위많이탐 캐주얼 4도
    var BAA4 = intArrayOf(
        R.drawable.w_casual_pinkweater,
        R.drawable.w_casual_onpi,
        R.drawable.w_casual_hood,
        R.drawable.w_casual_sropadding,
        R.drawable.w_casual_shorpadding,
        R.drawable.w_casual_longpadding,
        R.drawable.w_casual_gwskirt,
        R.drawable.w_casual_longskirt,
        R.drawable.w_casual_lightpants
    )
    var txt_BAA4 = arrayOf(
        "두꺼운 맨투맨", "두꺼운 원피스", "두꺼운 후드",
        "숏패딩", "숏패딩", "롱패딩",
        "두꺼운 스커트+스타킹", "두꺼운 긴스커트+스타킹", "기모 연청바지"
    )

    // 여자  더위많이탐 캐주얼 5도
    var BAA5 = intArrayOf(
        R.drawable.w_casual_pinkweater,
        R.drawable.w_casual_onpi,
        R.drawable.w_casual_hood,
        R.drawable.w_casual_sropadding,
        R.drawable.w_casual_shorpadding,
        R.drawable.w_casual_longpadding,
        R.drawable.w_casual_gwskirt,
        R.drawable.w_casual_longskirt,
        R.drawable.w_casual_lightpants
    )
    var txt_BAA5 = arrayOf(
        "두꺼운 맨투맨", "두꺼운 원피스", "두꺼운 후드",
        "숏패딩", "숏패딩", "롱패딩",
        "두꺼운 스커트+스타킹", "두꺼운 긴스커트+스타킹", "기모 연청바지"
    )

    // 여자  더위많이탐 캐주얼 9도
    var BAA9 = intArrayOf(
        R.drawable.w_casual_graysweat, R.drawable.w_casual_onpi, R.drawable.w_casual_hood,
        R.drawable.w_casual_sropadding, R.drawable.w_casual_longpadding, R.drawable.ic_xxx,
        R.drawable.w_casual_gwskirt, R.drawable.w_casual_longskirt, R.drawable.w_casual_lightpants
    )
    var txt_BAA9 = arrayOf(
        "두꺼운 긴티", "원피스", "후드",
        "숏패딩", "롱패딩", "",
        "두꺼운 스커트", "두꺼운 긴스커트+스타킹", "두꺼운 연청바지"
    )

    // 여자  더위많이탐 캐주얼 12도
    var BAA12 = intArrayOf(
        R.drawable.w_casual_graysweat, R.drawable.w_casual_onpi, R.drawable.w_casual_hood,
        R.drawable.w_casual_sropadding, R.drawable.w_casual_shorpadding, R.drawable.ic_xxx,
        R.drawable.w_casual_gwskirt, R.drawable.w_casual_longskirt, R.drawable.w_casual_lightpants
    )
    var txt_BAA12 = arrayOf(
        "긴티", "원피스", "얇은 후드",
        "숏패딩", "숏패딩", "",
        "스커트", "긴스커트", "연청바지"
    )

    // 여자  더위많이탐 캐주얼 17도
    var BAA17 = intArrayOf(
        R.drawable.w_casual_graysweat, R.drawable.w_casual_hood, R.drawable.w_casual_pinkweater,
        R.drawable.w_casual_neatjacket, R.drawable.w_casual_woolneat, R.drawable.ic_xxx,
        R.drawable.w_casual_gwskirt, R.drawable.w_casual_lightpants, R.drawable.ic_xxx
    )
    var txt_BAA17 = arrayOf(
        "얇은 긴티", "얇은 원피스", "얇은 후드",
        "얇은 자켓", "얇은 자켓", "",
        "스커트", "연청바지", ""
    )

    // 여자  더위많이탐 캐주얼 20도
    var BAA20 = intArrayOf(
        R.drawable.w_casual_orangeshirt, R.drawable.w_casual_graysweat, R.drawable.w_casual_onpi,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.f_pupple_shortpants, R.drawable.w_casual_shortpants, R.drawable.ic_xxx
    )
    var txt_BAA20 = arrayOf(
        "반팔셔츠", "맨투맨", "얇은 원피스",
        "", "", "",
        "반바지", "반바지", ""
    )

    // 여자  더위많이탐 캐주얼 23도
    var BAA23 = intArrayOf(
        R.drawable.w_casual_orangeshirt,
        R.drawable.w_pupple_short,
        R.drawable.w_casual_onpi,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.f_pupple_shortpants,
        R.drawable.w_casual_shortpants,
        R.drawable.sporty_shortpants01
    )
    var txt_BAA23 = arrayOf(
        "반팔셔츠", "반팔", "원피스",
        "", "", "",
        "반바지", "반바지", "반바지"
    )

    // 여자  더위많이탐 캐주얼 28도
    var BAA28 = intArrayOf(
        R.drawable.w_casual_orangeshirt,
        R.drawable.w_pupple_short,
        R.drawable.w_yellow_short,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.f_pupple_shortpants,
        R.drawable.w_casual_shortpants,
        R.drawable.sporty_shortpants01
    )
    var txt_BAA28 = arrayOf(
        "반팔셔츠", "반팔", "반팔",
        "", "", "",
        "반바지", "반바지", "반바지"
    )

    // 여자  더위적게탐 캐주얼 4도
    var BBA4 = intArrayOf(
        R.drawable.w_casual_pinkweater,
        R.drawable.w_casual_onpi,
        R.drawable.w_casual_hood,
        R.drawable.w_casual_sropadding,
        R.drawable.w_casual_shorpadding,
        R.drawable.w_casual_longpadding,
        R.drawable.w_casual_gwskirt,
        R.drawable.w_casual_longskirt,
        R.drawable.w_casual_lightpants
    )
    var txt_BBA4 = arrayOf(
        "두꺼운 맨투맨", "두꺼운 원피스", "두꺼운 후드",
        "숏패딩", "숏패딩", "롱패딩",
        "두꺼운 스커트+스타킹", "두꺼운 긴스커트+스타킹", "기모 연청바지"
    )

    // 여자  더위적게탐 캐주얼 5도
    var BBA5 = intArrayOf(
        R.drawable.w_casual_pinkweater,
        R.drawable.w_casual_onpi,
        R.drawable.w_casual_hood,
        R.drawable.w_casual_sropadding,
        R.drawable.w_casual_shorpadding,
        R.drawable.w_casual_longpadding,
        R.drawable.w_casual_gwskirt,
        R.drawable.w_casual_longskirt,
        R.drawable.w_casual_lightpants
    )
    var txt_BBA5 = arrayOf(
        "두꺼운 맨투맨", "두꺼운 원피스", "두꺼운 후드",
        "숏패딩", "숏패딩", "롱패딩",
        "두꺼운 스커트+스타킹", "두꺼운 긴스커트+스타킹", "기모 연청바지"
    )

    // 여자  더위적게탐 캐주얼 9도
    var BBA9 = intArrayOf(
        R.drawable.w_casual_graysweat, R.drawable.w_casual_onpi, R.drawable.w_casual_hood,
        R.drawable.w_casual_sropadding, R.drawable.w_casual_longpadding, R.drawable.ic_xxx,
        R.drawable.w_casual_gwskirt, R.drawable.w_casual_longskirt, R.drawable.w_casual_lightpants
    )
    var txt_BBA9 = arrayOf(
        "두꺼운 긴티", "두꺼운 원피스", "두꺼운 후드",
        "숏패딩", "롱패딩", "",
        "두꺼운 스커트+스타킹", "두꺼운 긴스커트+스타킹", "두꺼운 연청바지"
    )

    // 여자  더위적게탐 캐주얼 12도
    var BBA12 = intArrayOf(
        R.drawable.w_casual_graysweat, R.drawable.w_casual_onpi, R.drawable.w_casual_hood,
        R.drawable.w_casual_sropadding, R.drawable.w_casual_shorpadding, R.drawable.ic_xxx,
        R.drawable.w_casual_gwskirt, R.drawable.w_casual_longskirt, R.drawable.w_casual_lightpants
    )
    var txt_BBA12 = arrayOf(
        "두꺼운 긴티", "두꺼운 원피스", "후드",
        "숏패딩", "숏패딩", "",
        "스커트", "긴스커트", "연청바지"
    )

    // 여자  더위적게탐 캐주얼 17도
    var BBA17 = intArrayOf(
        R.drawable.w_casual_graysweat, R.drawable.w_casual_hood, R.drawable.w_casual_pinkweater,
        R.drawable.w_casual_neatjacket, R.drawable.w_casual_woolneat, R.drawable.ic_xxx,
        R.drawable.w_casual_gwskirt, R.drawable.w_casual_lightpants, R.drawable.ic_xxx
    )
    var txt_BBA17 = arrayOf(
        "얇은 긴티", "후드", "긴 맨투맨",
        "자켓", "자켓", "",
        "스커트", "연청바지", ""
    )

    // 여자  더위적게탐 캐주얼 20도
    var BBA20 = intArrayOf(
        R.drawable.w_casual_orangeshirt, R.drawable.w_casual_graysweat, R.drawable.w_casual_onpi,
        R.drawable.w_casual_neatjacket, R.drawable.w_casual_woolneat, R.drawable.ic_xxx,
        R.drawable.f_pupple_shortpants, R.drawable.w_casual_shortpants, R.drawable.ic_xxx
    )
    var txt_BBA20 = arrayOf(
        "반팔셔츠", "긴팔", "원피스",
        "자켓", "얇은 자켓", "",
        "반바지", "반바지", ""
    )

    // 여자  더위적게탐 캐주얼 23도
    var BBA23 = intArrayOf(
        R.drawable.w_casual_orangeshirt,
        R.drawable.w_pupple_short,
        R.drawable.w_casual_onpi,
        R.drawable.w_casual_neatjacket,
        R.drawable.w_casual_woolneat,
        R.drawable.ic_xxx,
        R.drawable.f_pupple_shortpants,
        R.drawable.w_casual_shortpants,
        R.drawable.sporty_shortpants01
    )
    var txt_BBA23 = arrayOf(
        "반팔셔츠", "반팔", "원피스",
        "자켓", "자켓", "",
        "반바지", "반바지", "반바지"
    )

    // 여자  더위적게탐 캐주얼 28도
    var BBA28 = intArrayOf(
        R.drawable.w_casual_orangeshirt,
        R.drawable.w_pupple_short,
        R.drawable.w_yellow_short,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.f_pupple_shortpants,
        R.drawable.w_casual_shortpants,
        R.drawable.sporty_shortpants01
    )
    var txt_BBA28 = arrayOf(
        "반팔셔츠", "반팔", "반팔",
        "", "", "",
        "반바지", "반바지", "반바지"
    )

    //***************************************************************************************************
    // TODO : 스포티 스타일 BAE, BBE
    // TODO : 여 더위많이탐 스포티 4도
    var BAE4 = intArrayOf(
        R.drawable.sporty_blackmtm, R.drawable.f_sporty_longsleeve, R.drawable.ic_xxx,
        R.drawable.sporty_trainingheavyouter, R.drawable.f_longpadding, R.drawable.longpadding,
        R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings, R.drawable.ic_xxx
    )
    var txt_BAE4 = arrayOf(
        "기모 맨투맨", "긴팔", "",
        "두꺼운 트레이닝복", "롱패딩", "롱패딩",
        "기모 바지", "기모 레깅스", ""
    )
    var BAE5 = intArrayOf(
        R.drawable.sporty_blackmtm, R.drawable.f_sporty_longsleeve, R.drawable.ic_xxx,
        R.drawable.sporty_trainingheavyouter, R.drawable.f_longpadding, R.drawable.longpadding,
        R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings, R.drawable.ic_xxx
    )
    var txt_BAE5 = arrayOf(
        "기모 맨투맨", "긴팔", "",
        "두꺼운 트레이닝복", "롱패딩", "롱패딩",
        "기모 바지", "기모 레깅스", ""
    )
    var BAE9 = intArrayOf(
        R.drawable.sporty_blackmtm, R.drawable.f_sporty_longsleeve, R.drawable.ic_xxx,
        R.drawable.sporty_trainingheavyouter, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_jogger, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BAE9 = arrayOf(
        "맨투맨", "긴팔", "",
        "두꺼운 트레이닝복", "", "",
        "두꺼운 조거 팬츠", "두꺼운 트레이닝 바지", "두꺼운 레깅스"
    )
    var BAE12 = intArrayOf(
        R.drawable.sporty_blackmtm, R.drawable.white_tshirt, R.drawable.black_short,
        R.drawable.sporty_trainingouter, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_jogger, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BAE12 = arrayOf(
        "맨투맨", "셔츠", "반팔",
        "트레이닝복", "", "",
        "조거 팬츠", "트레이닝 바지", "레깅스"
    )
    var BAE17 = intArrayOf(
        R.drawable.black_short, R.drawable.white_tshirt, R.drawable.yellow_short,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_jogger, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BAE17 = arrayOf(
        "반팔", "반팔", "반팔",
        "", "", "",
        "조거 팬츠", "트레이닝 바지", "레깅스"
    )
    var BAE20 = intArrayOf(
        R.drawable.black_short, R.drawable.white_tshirt, R.drawable.yellow_short,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_jogger, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BAE20 = arrayOf(
        "반팔", "반팔", "반팔",
        "", "", "",
        "얇은 조거 팬츠", "얇은 트레이닝 바지", "얇은 레깅스"
    )
    var BAE23 = intArrayOf(
        R.drawable.white_nasi, R.drawable.white_tshort, R.drawable.ic_xxx,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_shortpants, R.drawable.sporty_trainingpants, R.drawable.ic_xxx
    )
    var txt_BAE23 = arrayOf(
        "나시", "반팔", "",
        "", "", "",
        "반바지", "얇은 트레이닝 바지", ""
    )
    var BAE28 = intArrayOf(
        R.drawable.m_sporty_nasi, R.drawable.white_nasi, R.drawable.white_tshort,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_shortpants, R.drawable.f_trainingleggings, R.drawable.ic_xxx
    )
    var txt_BAE28 = arrayOf(
        "나시", "나시", "반팔",
        "", "", "",
        "반바지", "얇은 트레이닝 바지", ""
    )

    // 여 더위적게탐 스포티 4도
    var BBE4 = intArrayOf(
        R.drawable.sporty_blackmtm, R.drawable.f_sporty_longsleeve, R.drawable.ic_xxx,
        R.drawable.sporty_trainingheavyouter, R.drawable.f_longpadding, R.drawable.longpadding,
        R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings, R.drawable.ic_xxx
    )
    var txt_BBE4 = arrayOf(
        "기모 맨투맨", "긴팔", "",
        "두꺼운 트레이닝복", "롱패딩", "롱패딩",
        "기모 바지", "기모 레깅스", ""
    )
    var BBE5 = intArrayOf(
        R.drawable.sporty_blackmtm, R.drawable.f_sporty_longsleeve, R.drawable.ic_xxx,
        R.drawable.sporty_trainingheavyouter, R.drawable.f_longpadding, R.drawable.longpadding,
        R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings, R.drawable.ic_xxx
    )
    var txt_BBE5 = arrayOf(
        "기모 맨투맨", "긴팔", "",
        "두꺼운 트레이닝복", "롱패딩", "롱패딩",
        "기모 바지", "기모 레깅스", ""
    )
    var BBE9 = intArrayOf(
        R.drawable.sporty_blackmtm, R.drawable.f_sporty_longsleeve, R.drawable.ic_xxx,
        R.drawable.sporty_trainingheavyouter, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_jogger, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BBE9 = arrayOf(
        "맨투맨", "긴팔", "",
        "두꺼운 트레이닝복", "", "",
        "두꺼운 조거 팬츠", "두꺼운 트레이닝 바지", "두꺼운 레깅스"
    )
    var BBE12 = intArrayOf(
        R.drawable.sporty_blackmtm, R.drawable.white_tshirt, R.drawable.black_short,
        R.drawable.sporty_trainingouter, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_jogger, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BBE12 = arrayOf(
        "맨투맨", "셔츠", "반팔",
        "트레이닝복", "", "",
        "조거 팬츠", "트레이닝 바지", "레깅스"
    )
    var BBE17 = intArrayOf(
        R.drawable.black_short, R.drawable.white_tshirt, R.drawable.yellow_short,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_jogger, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BBE17 = arrayOf(
        "반팔", "반팔", "반팔",
        "", "", "",
        "조거 팬츠", "트레이닝 바지", "레깅스"
    )
    var BBE20 = intArrayOf(
        R.drawable.black_short, R.drawable.white_tshirt, R.drawable.yellow_short,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_jogger, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BBE20 = arrayOf(
        "반팔", "반팔", "반팔",
        "", "", "",
        "조거 팬츠", "트레이닝 바지", "레깅스"
    )
    var BBE23 = intArrayOf(
        R.drawable.white_nasi, R.drawable.white_tshort, R.drawable.ic_xxx,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_shortpants, R.drawable.sporty_trainingpants, R.drawable.f_trainingleggings
    )
    var txt_BBE23 = arrayOf(
        "나시", "반팔", "",
        "", "", "",
        "반바지", "얇은 트레이닝 바지", "얇은 레깅스"
    )
    var BBE28 = intArrayOf(
        R.drawable.m_sporty_nasi, R.drawable.white_nasi, R.drawable.white_tshort,
        R.drawable.ic_xxx, R.drawable.ic_xxx, R.drawable.ic_xxx,
        R.drawable.sporty_shortpants, R.drawable.f_trainingleggings, R.drawable.f_trainingleggings
    )
    var txt_BBE28 = arrayOf(
        "나시", "나시", "반팔",
        "", "", "",
        "반바지", "얇은 트레이닝 바지", "얇은 레깅스"
    )

    //***************************************************************************************************
    // 빈티지 스타일 BAB, BBB
    // 여 더위많이탐 빈티지
    var BAB4 = intArrayOf(
        R.drawable.f_vintage_longshirt, R.drawable.vintage_longshirt, R.drawable.sporty_blackmtm,
        R.drawable.vintage_shortpadding, R.drawable.f_vintage_coat, R.drawable.longpadding,
        R.drawable.vintage_jean, R.drawable.f_vintage_skirt, R.drawable.f_vintage_skirt2
    )
    var txt_BAB4 = arrayOf(
        "긴팔 셔츠", "긴팔 셔츠", "기모 긴팔",
        "숏패딩", "헤비 코트", "롱패딩",
        "기모 청바지", "치마+기모스타킹", "치마+기모스타킹"
    )
    var BAB5 = intArrayOf(
        R.drawable.f_vintage_longshirt, R.drawable.vintage_longshirt, R.drawable.sporty_blackmtm,
        R.drawable.vintage_shortpadding, R.drawable.f_vintage_coat, R.drawable.longpadding,
        R.drawable.vintage_jean, R.drawable.f_vintage_skirt, R.drawable.f_vintage_skirt2
    )
    var txt_BAB5 = arrayOf(
        "긴팔 셔츠", "긴팔 셔츠", "기모 긴팔",
        "숏패딩", "헤비 코트", "롱패딩",
        "기모 청바지", "치마+기모스타킹", "치마+기모스타킹"
    )
    var BAB9 = intArrayOf(
        R.drawable.f_vintage_longshirt, R.drawable.vintage_longshirt, R.drawable.sporty_blackmtm,
        R.drawable.f_vintage_gardigun, R.drawable.f_vintage_coat, R.drawable.f_vintage_jaket,
        R.drawable.vintage_jean, R.drawable.f_vintage_skirt, R.drawable.f_vintage_skirt2
    )
    var txt_BAB9 = arrayOf(
        "긴팔 셔츠", "긴팔 셔츠", "기모 긴팔",
        "두꺼운 가디건", "헤비 코트", "두꺼운 자켓",
        "기모 청바지", "치마+기모스타킹", "치마+기모스타킹"
    )
    var BAB12 = intArrayOf(
        R.drawable.f_vintage_longshirt, R.drawable.vintage_longshirt, R.drawable.sporty_blackmtm,
        R.drawable.f_vintage_gardigun, R.drawable.f_vintage_coat, R.drawable.f_vintage_jaket,
        R.drawable.vintage_jean, R.drawable.f_vintage_skirt, R.drawable.f_vintage_skirt2
    )
    var txt_BAB12 = arrayOf(
        "긴팔 셔츠", "긴팔 셔츠", "기모 긴팔",
        "얇은 가디건", "헤비 코트", "얇은 자켓",
        "기모 청바지", "치마+스타킹", "치마+스타킹"
    )
    var BAB17 = intArrayOf(
        R.drawable.f_vintage_shorttshirt,
        R.drawable.f_vintage_shorttshirt2,
        R.drawable.pupple_short,
        R.drawable.f_vintage_gardigun,
        R.drawable.f_vintage_longshirt,
        R.drawable.f_vintage_jaket,
        R.drawable.vintage_jean,
        R.drawable.f_vintage_skirt,
        R.drawable.f_vintage_skirt2
    )
    var txt_BAB17 = arrayOf(
        "반팔", "반팔", "반팔",
        "가디건", "긴팔 셔츠", "자켓",
        "청바지", "치마", "치마"
    )
    var BAB20 = intArrayOf(
        R.drawable.f_vintage_shorttshirt,
        R.drawable.f_vintage_shorttshirt2,
        R.drawable.pupple_short,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.vintage_jean,
        R.drawable.f_vintage_skirt,
        R.drawable.f_vintage_skirt2
    )
    var txt_BAB20 = arrayOf(
        "반팔", "반팔", "반팔",
        "", "", "",
        "얇은 청바지", "치마", "치마"
    )
    var BAB23 = intArrayOf(
        R.drawable.f_vintage_shorttshirt,
        R.drawable.f_vintage_shorttshirt2,
        R.drawable.pupple_short,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.vintage_shortpants2,
        R.drawable.f_vintage_skirt,
        R.drawable.f_vintage_skirt2
    )
    var txt_BAB23 = arrayOf(
        "반팔", "반팔", "반팔",
        "", "", "",
        "반바지", "치마", "치마"
    )
    var BAB28 = intArrayOf(
        R.drawable.f_vintage_shorttshirt,
        R.drawable.f_vintage_shorttshirt2,
        R.drawable.pupple_short,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.vintage_shortpants2,
        R.drawable.f_vintage_skirt,
        R.drawable.f_vintage_skirt2
    )
    var txt_BAB28 = arrayOf(
        "반팔", "반팔", "반팔",
        "", "", "",
        "반바지", "치마", "치마"
    )

    // 여 더위적게탐 빈티지
    var BBB4 = intArrayOf(
        R.drawable.f_vintage_longshirt, R.drawable.vintage_longshirt, R.drawable.sporty_blackmtm,
        R.drawable.vintage_shortpadding, R.drawable.f_vintage_coat, R.drawable.longpadding,
        R.drawable.vintage_jean, R.drawable.f_vintage_skirt, R.drawable.f_vintage_skirt2
    )
    var txt_BBB4 = arrayOf(
        "긴팔 셔츠", "긴팔 셔츠", "기모 긴팔",
        "숏패딩", "헤비 코트", "롱패딩",
        "기모 청바지", "치마+기모스타킹", "치마+기모스타킹"
    )
    var BBB5 = intArrayOf(
        R.drawable.f_vintage_longshirt, R.drawable.vintage_longshirt, R.drawable.sporty_blackmtm,
        R.drawable.vintage_shortpadding, R.drawable.f_vintage_coat, R.drawable.longpadding,
        R.drawable.vintage_jean, R.drawable.f_vintage_skirt, R.drawable.f_vintage_skirt2
    )
    var txt_BBB5 = arrayOf(
        "긴팔 셔츠", "긴팔 셔츠", "기모 긴팔",
        "숏패딩", "헤비 코트", "롱패딩",
        "기모 청바지", "치마+기모스타킹", "치마+기모스타킹"
    )
    var BBB9 = intArrayOf(
        R.drawable.f_vintage_longshirt, R.drawable.vintage_longshirt, R.drawable.sporty_blackmtm,
        R.drawable.f_vintage_gardigun, R.drawable.f_vintage_coat, R.drawable.f_vintage_jaket,
        R.drawable.vintage_jean, R.drawable.f_vintage_skirt, R.drawable.f_vintage_skirt2
    )
    var txt_BBB9 = arrayOf(
        "긴팔 셔츠", "긴팔 셔츠", "기모 긴팔",
        "두꺼운 가디건", "헤비 코트", "두꺼운 자켓",
        "두꺼운 청바지", "치마+기모스타킹", "치마+기모스타킹"
    )
    var BBB12 = intArrayOf(
        R.drawable.f_vintage_longshirt, R.drawable.vintage_longshirt, R.drawable.sporty_blackmtm,
        R.drawable.f_vintage_gardigun, R.drawable.f_vintage_coat, R.drawable.f_vintage_jaket,
        R.drawable.vintage_jean, R.drawable.f_vintage_skirt, R.drawable.f_vintage_skirt2
    )
    var txt_BBB12 = arrayOf(
        "긴팔 셔츠", "긴팔 셔츠", "긴팔",
        "두꺼운 가디건", "코트", "두꺼운 자켓",
        "청바지", "치마+스타킹", "치마+스타킹"
    )
    var BBB17 = intArrayOf(
        R.drawable.f_vintage_shorttshirt,
        R.drawable.f_vintage_shorttshirt2,
        R.drawable.pupple_short,
        R.drawable.f_vintage_gardigun,
        R.drawable.f_vintage_longshirt,
        R.drawable.f_vintage_jaket,
        R.drawable.vintage_jean,
        R.drawable.f_vintage_skirt,
        R.drawable.f_vintage_skirt2
    )
    var txt_BBB17 = arrayOf(
        "반팔", "반팔", "반팔",
        "가디건", "긴팔 셔츠", "자켓",
        "얇은 청바지", "치마+스타킹", "치마+스타킹"
    )
    var BBB20 = intArrayOf(
        R.drawable.f_vintage_shorttshirt,
        R.drawable.f_vintage_shorttshirt2,
        R.drawable.pupple_short,
        R.drawable.f_vintage_gardigun,
        R.drawable.f_vintage_longshirt,
        R.drawable.f_vintage_jaket,
        R.drawable.vintage_jean,
        R.drawable.f_vintage_skirt,
        R.drawable.f_vintage_skirt2
    )
    var txt_BBB20 = arrayOf(
        "반팔", "반팔", "반팔",
        "가디건", "긴 셔츠", "자켓",
        "얇은 청바지", "치마", "치마"
    )
    var BBB23 = intArrayOf(
        R.drawable.f_vintage_shorttshirt,
        R.drawable.f_vintage_shorttshirt2,
        R.drawable.pupple_short,
        R.drawable.f_vintage_longshirt,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.vintage_shortpants2,
        R.drawable.f_vintage_skirt,
        R.drawable.f_vintage_skirt2
    )
    var txt_BBB23 = arrayOf(
        "반팔", "반팔", "반팔",
        "반팔 대신 셔츠", "", "",
        "반바지", "치마", "치마"
    )
    var BBB28 = intArrayOf(
        R.drawable.f_vintage_shorttshirt,
        R.drawable.f_vintage_shorttshirt2,
        R.drawable.pupple_short,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.vintage_shortpants2,
        R.drawable.f_vintage_skirt,
        R.drawable.f_vintage_skirt2
    )
    var txt_BBB28 = arrayOf(
        "반팔", "반팔", "반팔",
        "", "", "",
        "반바지", "치마", "치마"
    )

    //***************************************************************************************************
    // TODO : 스트릿 스타일
    // TODO : 여 더위많이탐 스트릿 BAC BBC
    var BAC4 = intArrayOf(
        R.drawable.f_street_hood,
        R.drawable.street_warm_knet,
        R.drawable.street_warm_neck,
        R.drawable.street_short_padding,
        R.drawable.f_street_feather_jacket,
        R.drawable.street_baseball,
        R.drawable.street_jogger,
        R.drawable.street_cago,
        R.drawable.street_sweat_pants
    )
    var txt_BAC4 = arrayOf(
        "기모 후드티", "니트", "목폴람티",
        "숏패딩", "털 자켓", "바시티 자켓",
        "기모 조거 팬츠", "기모 카고 팬츠", "기모 스웻 팬츠"
    )
    var BAC5 = intArrayOf(
        R.drawable.f_street_hood,
        R.drawable.street_warm_knet,
        R.drawable.street_warm_neck,
        R.drawable.street_short_padding,
        R.drawable.f_street_feather_jacket,
        R.drawable.street_baseball,
        R.drawable.street_jogger,
        R.drawable.street_cago,
        R.drawable.street_sweat_pants
    )
    var txt_BAC5 = arrayOf(
        "기모 후드티", "니트", "목폴람티",
        "숏패딩", "털 자켓", "바시티 자켓",
        "기모 조거 팬츠", "기모 카고 팬츠", "기모 스웻 팬츠"
    )
    var BAC9 = intArrayOf(
        R.drawable.f_street_hood,
        R.drawable.street_warm_knet,
        R.drawable.street_t_shirt,
        R.drawable.street_denim_jacket,
        R.drawable.f_street_feather_jacket,
        R.drawable.f_street_coat,
        R.drawable.street_jogger,
        R.drawable.street_baggie_pants,
        R.drawable.street_trainning
    )
    var txt_BAC9 = arrayOf(
        "기모 후드티", "니트", "긴팔티",
        "데님 자켓", "털 자켓", "코트",
        "두꺼운 조거 팬츠", "두꺼운 베기 팬츠", "두꺼운 트레이닝바지"
    )
    var BAC12 = intArrayOf(
        R.drawable.f_street_hood, R.drawable.street_warm_knet, R.drawable.street_t_shirt,
        R.drawable.street_denim_jacket, R.drawable.f_street_blaz, R.drawable.f_street_coat,
        R.drawable.street_jogger, R.drawable.street_baggie_pants, R.drawable.street_trainning
    )
    var txt_BAC12 = arrayOf(
        "후드티", "니트", "긴팔티",
        "데님 자켓", "블레이저", "코트",
        "조거 팬츠", "베기 팬츠", "트레이닝바지"
    )
    var BAC17 = intArrayOf(
        R.drawable.street_shirts, R.drawable.f_street__long_sleeve, R.drawable.street_t_shirt,
        R.drawable.f_street__crop_jacket, R.drawable.f_street_blaz, R.drawable.f_street_windbreaker,
        R.drawable.street_jogger, R.drawable.street_jjiz_jeans, R.drawable.street_trainning
    )
    var txt_BAC17 = arrayOf(
        "셔츠", "롱 슬리브", "긴팔티",
        "얇은 자켓", "블레이저", "바람막이",
        "조거 팬츠", "청바지", "트레이닝바지"
    )
    var BAC20 = intArrayOf(
        R.drawable.street_shirts, R.drawable.f_street__long_sleeve, R.drawable.street_t_shirt,
        R.drawable.f_street__crop_jacket, R.drawable.f_street_blaz, R.drawable.f_street_windbreaker,
        R.drawable.street_jogger, R.drawable.street_jjiz_jeans, R.drawable.street_trainning
    )
    var txt_BAC20 = arrayOf(
        "얇은 셔츠", "롱 슬리브", "긴팔티",
        "얇은 자켓", "블레이저", "바람막이",
        "조거 팬츠", "청바지", "트레이닝바지"
    )
    var BAC23 = intArrayOf(
        R.drawable.street_shirts,
        R.drawable.f_street__short_tshirts,
        R.drawable.f_street__nasi,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.f_street__short_pants,
        R.drawable.f_street__short_skirt,
        R.drawable.street_trainning
    )
    var txt_BAC23 = arrayOf(
        "얇은 셔츠", "반팔티", "민소매",
        "", "", "",
        "반바지", "치마", "얇은 트레이닝바지"
    )
    var BAC28 = intArrayOf(
        R.drawable.street_shirts,
        R.drawable.f_street__short_tshirts,
        R.drawable.f_street__nasi,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.f_street__short_pants,
        R.drawable.f_street__short_skirt,
        R.drawable.street_trainning
    )
    var txt_BAC28 = arrayOf(
        "얇은 셔츠", "반팔티", "민소매",
        "", "", "",
        "반바지", "치마", "얇은 트레이닝바지"
    )

    // 여 더위적게탐 스트릿 BAC BBC
    var BBC4 = intArrayOf(
        R.drawable.f_street_hood,
        R.drawable.street_warm_knet,
        R.drawable.street_warm_neck,
        R.drawable.street_short_padding,
        R.drawable.f_street_feather_jacket,
        R.drawable.street_baseball,
        R.drawable.street_jogger,
        R.drawable.street_cago,
        R.drawable.street_sweat_pants
    )
    var txt_BBC4 = arrayOf(
        "기모 후드티", "니트", "목폴람티",
        "숏패딩", "털 자켓", "바시티 자켓",
        "기모 조거 팬츠", "기모 카고 팬츠", "기모 스웻 팬츠"
    )
    var BBC5 = intArrayOf(
        R.drawable.f_street_hood,
        R.drawable.street_warm_knet,
        R.drawable.street_warm_neck,
        R.drawable.street_short_padding,
        R.drawable.f_street_feather_jacket,
        R.drawable.street_baseball,
        R.drawable.street_jogger,
        R.drawable.street_cago,
        R.drawable.street_sweat_pants
    )
    var txt_BBC5 = arrayOf(
        "기모 후드티", "니트", "목폴람티",
        "숏패딩", "털 자켓", "바시티 자켓",
        "기모 조거 팬츠", "기모 카고 팬츠", "기모 스웻 팬츠"
    )
    var BBC9 = intArrayOf(
        R.drawable.f_street_hood,
        R.drawable.street_warm_knet,
        R.drawable.street_t_shirt,
        R.drawable.street_denim_jacket,
        R.drawable.f_street_feather_jacket,
        R.drawable.f_street_coat,
        R.drawable.street_jogger,
        R.drawable.street_baggie_pants,
        R.drawable.street_trainning
    )
    var txt_BBC9 = arrayOf(
        "기모 후드티", "니트", "긴팔티",
        "데님 자켓", "털 자켓", "코트",
        "두꺼운 조거 팬츠", "두꺼운 베기 팬츠", "두꺼운 트레이닝바지"
    )
    var BBC12 = intArrayOf(
        R.drawable.f_street_hood, R.drawable.street_warm_knet, R.drawable.street_t_shirt,
        R.drawable.street_denim_jacket, R.drawable.f_street_blaz, R.drawable.f_street_coat,
        R.drawable.street_jogger, R.drawable.street_baggie_pants, R.drawable.street_trainning
    )
    var txt_BBC12 = arrayOf(
        "후드티", "니트", "긴팔티",
        "데님 자켓", "블레이저", "코트",
        "조거 팬츠", "베기 팬츠", "트레이닝바지"
    )
    var BBC17 = intArrayOf(
        R.drawable.street_shirts, R.drawable.f_street__knet_sweater, R.drawable.street_t_shirt,
        R.drawable.f_street__crop_jacket, R.drawable.f_street_blaz, R.drawable.f_street_windbreaker,
        R.drawable.street_jogger, R.drawable.street_jjiz_jeans, R.drawable.street_trainning
    )
    var txt_BBC17 = arrayOf(
        "셔츠", "니트", "긴팔티",
        "자켓", "블레이저", "바람막이",
        "조거 팬츠", "청바지", "트레이닝바지"
    )
    var BBC20 = intArrayOf(
        R.drawable.street_shirts, R.drawable.f_street__long_sleeve, R.drawable.street_t_shirt,
        R.drawable.f_street__crop_jacket, R.drawable.f_street_blaz, R.drawable.f_street_windbreaker,
        R.drawable.street_jogger, R.drawable.street_jjiz_jeans, R.drawable.street_trainning
    )
    var txt_BBC20 = arrayOf(
        "셔츠", "롱 슬리브", "긴팔티",
        "얇은 자켓", "블레이저", "바람막이",
        "얇은 조거 팬츠", "얇은 청바지", "얇은 트레이닝바지"
    )
    var BBC23 = intArrayOf(
        R.drawable.street_shirts,
        R.drawable.f_street__short_tshirts,
        R.drawable.f_street__nasi,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.f_street__short_pants,
        R.drawable.f_street__short_skirt,
        R.drawable.street_trainning
    )
    var txt_BBC23 = arrayOf(
        "얇은 셔츠", "반팔티", "민소매",
        "", "", "",
        "반바지", "치마", "얇은 트레이닝바지"
    )
    var BBC28 = intArrayOf(
        R.drawable.street_shirts,
        R.drawable.f_street__short_tshirts,
        R.drawable.f_street__nasi,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.ic_xxx,
        R.drawable.f_street__short_pants,
        R.drawable.f_street__short_skirt,
        R.drawable.street_trainning
    )
    var txt_BBC28 = arrayOf(
        "얇은 셔츠", "반팔티", "민소매",
        "", "", "",
        "반바지", "치마", "얇은 트레이닝바지"
    )
}