package com.learner.codereducer.utils

object CurrencySymbols {

    fun getSymbolOf(shortForm: String) = symbols[shortForm]

    /**To uncomment this., Please add billing library first*/
    /*fun getPriceWithSymbol(skuDetails: SkuDetails): String {
        var currSymbol: String?
        //Finding Currency symbol
        //1st Way
        currSymbol = getSymbolOf(skuDetails.priceCurrencyCode)
        //2nd way
        if (currSymbol == null) {
            var txt = skuDetails.price
            while (txt.length > 3 && !txt.last().isLetter()) txt = txt.dropLast(1)
            currSymbol = getSymbolOf(txt)
        }
        //if not found symbol return google preferred way
        return if (currSymbol.isNullOrEmpty()) skuDetails.price
        else skuDetails.price
            .replace(skuDetails.priceCurrencyCode, currSymbol)
            .replace(" ", "")
    }*/

    private var symbols = hashMapOf(
        "AFN" to "؋",//Afghanistan
        "EUR" to "€",//Akrotiri and Dhekelia
        "ALL" to "L",//Albania
        "GBP" to "£",//Alderney
        "GGP" to "£",//Alderney
        "DZD" to "د.ج",//Algeria
        "EUR" to "€",//Andorra
        "AOA" to "Kz",//Angola
        "XCD" to "$",//Anguilla
        "XCD" to "$",//Antigua and Barbuda
        "ARS" to "$",//Argentina
        "AMD" to "֏",//Armenia
        "AWG" to "ƒ",//Aruba
        "SHP" to "£",//Ascension Island
        "AUD" to "$",//Australia
        "EUR" to "€",//Austria
        "AZN" to "₼",//Azerbaijan
        "BSD" to "$",//Bahamas, The
        "BHD" to ".د.ب",//Bahrain
        "BDT" to "৳",//Bangladesh
        "BBD" to "$",//Barbados
        "BYR" to "Br",//Belarus
        "EUR" to "€",//Belgium
        "BZD" to "$",//Belize
        "XOF" to "Fr",//Benin
        "BMD" to "$",//Bermuda
        "BTN" to "Nu.",//Bhutan
        "INR" to "₹",//Bhutan
        "BOB" to "Bs.",//Bolivia
        "USD" to "$",//Bonaire
        "BWP" to "P",//Botswana
        "BRL" to "R$",//Brazil
        "USD" to "$",//British Indian Ocean Territory
        "USD" to "$",//British Virgin Islands
        "BND" to "$",//Brunei
        "SGD" to "$",//Brunei
        "BGN" to "лв",//Bulgaria
        "XOF" to "Fr",//Burkina Faso
        "BIF" to "Fr",//Burundi
        "KHR" to "៛",//Cambodia
        "USD" to "$",//Cambodia
        "XAF" to "Fr",//Cameroon
        "CAD" to "$",//Canada
        "CVE" to "$",//Cape Verde
        "KYD" to "$",//Cayman Islands
        "XAF" to "Fr",//Central African Republic
        "XAF" to "Fr",//Chad
        "CLP" to "$",//Chile
        "CNY" to "¥",//China
        "AUD" to "$",//Cocos (Keeling) Islands
        "COP" to "$",//Colombia
        "KMF" to "Fr",//Comoros
        "CDF" to "Fr",//Congo, Democratic Republic of the
        "XAF" to "Fr",//Congo, Republic of the
        "NZD" to "$",//Cook Islands
        "CRC" to "₡",//Costa Rica
        "XOF" to "Fr",//Côte d'Ivoire
        "HRK" to "kn",//Croatia
        "CUC" to "$",//Cuba
        "CUP" to "$",//Cuba
        "ANG" to "ƒ",//Curaçao
        "EUR" to "€",//Cyprus
        "CZK" to "Kč",//Czech Republic
        "DKK" to "kr",//Denmark
        "DJF" to "Fr",//Djibouti
        "XCD" to "$",//Dominica
        "DOP" to "$",//Dominican Republic
        "USD" to "$",//East Timor
        "USD" to "$",//Ecuador
        "EGP" to "£",//Egypt
        "USD" to "$",//El Salvador
        "XAF" to "Fr",//Equatorial Guinea
        "ERN" to "Nfk",//Eritrea
        "EUR" to "€",//Estonia
        "ETB" to "Br",//Ethiopia
        "FKP" to "£",//Falkland Islands
        "DKK" to "kr",//Faroe Islands
        "FJD" to "$",//Fiji
        "EUR" to "€",//Finland
        "EUR" to "€",//France
        "XPF" to "Fr",//French Polynesia
        "XAF" to "Fr",//Gabon
        "GMD" to "D",//Gambia, The
        "GEL" to "ლ",//Georgia
        "EUR" to "€",//Germany
        "GHS" to "₵",//Ghana
        "GIP" to "£",//Gibraltar
        "EUR" to "€",//Greece
        "XCD" to "$",//Grenada
        "GTQ" to "Q",//Guatemala
        "GBP" to "£",//Guernsey
        "GNF" to "Fr",//Guinea
        "XOF" to "Fr",//Guinea-Bissau
        "GYD" to "$",//Guyana
        "HTG" to "G",//Haiti
        "HNL" to "L",//Honduras
        "HKD" to "$",//Hong Kong
        "HUF" to "Ft",//Hungary
        "ISK" to "kr",//Iceland
        "INR" to "₹",//India
        "IDR" to "Rp",//Indonesia
        "IRR" to "﷼",//Iran
        "IQD" to "ع.د",//Iraq
        "EUR" to "€",//Ireland
        "GBP" to "£",//Isle of Man
        "ILS" to "₪",//Israel
        "EUR" to "€",//Italy
        "JMD" to "$",//Jamaica
        "JPY" to "¥",//Japan
        "GBP" to "£",//Jersey
        "JOD" to "د.ا",//Jordan
        "KZT" to "₸",//Kazakhstan
        "KES" to "Sh",//Kenya
        "AUD" to "$",//Kiribati
        "KPW" to "₩",//Korea, North
        "KRW" to "₩",//Korea, South
        "EUR" to "€",//Kosovo
        "KWD" to "د.ك",//Kuwait
        "KGS" to "лв",//Kyrgyzstan
        "LAK" to "₭",//Laos
        "EUR" to "€",//Latvia
        "LBP" to "ل.ل",//Lebanon
        "LSL" to "L",//Lesotho
        "ZAR" to "R",//Lesotho
        "LRD" to "$",//Liberia
        "LYD" to "ل.د",//Libya
        "CHF" to "Fr",//Liechtenstein
        "EUR" to "€",//Lithuania
        "EUR" to "€",//Luxembourg
        "MOP" to "P",//Macau
        "MKD" to "ден",//Macedonia, Republic of
        "MGA" to "Ar",//Madagascar
        "MWK" to "MK",//Malawi
        "MYR" to "RM",//Malaysia
        "MVR" to ".ރ",//Maldives
        "XOF" to "Fr",//Mali
        "EUR" to "€",//Malta
        "USD" to "$",//Marshall Islands
        "MRO" to "UM",//Mauritania
        "MUR" to "₨",//Mauritius
        "MXN" to "$",//Mexico
        "USD" to "$",//Micronesia
        "MDL" to "L",//Moldova
        "EUR" to "€",//Monaco
        "MNT" to "₮",//Mongolia
        "EUR" to "€",//Montenegro
        "XCD" to "$",//Montserrat
        "MAD" to "د.م.",//Morocco
        "MZN" to "MT",//Mozambique
        "MMK" to "Ks",//Myanmar
        "AMD" to "դր.",//Nagorno-Karabakh Republic
        "NAD" to "$",//Namibia
        "ZAR" to "R",//Namibia
        "AUD" to "$",//Nauru
        "NPR" to "₨",//Nepal
        "EUR" to "€",//Netherlands
        "XPF" to "Fr",//New Caledonia
        "NZD" to "$",//New Zealand
        "NIO" to "C$",//Nicaragua
        "XOF" to "Fr",//Niger
        "NGN" to "₦",//Nigeria
        "NZD" to "$",//Niue
        "TRY" to "",//Northern Cyprus
        "NOK" to "kr",//Norway
        "OMR" to "ر.ع.",//Oman
        "PKR" to "₨",//Pakistan
        "USD" to "$",//Pakistan
        "ILS" to "₪",//Palestine
        "JOD" to "د.ا",//Palestine
        "PAB" to "B/.",//Panama
        "USD" to "$",//Panama
        "PGK" to "K",//Papua New Guinea
        "PYG" to "₲",//Paraguay
        "PEN" to "S/.",//Peru
        "PHP" to "₱",//Philippines
        "NZD" to "$",//Pitcairn Islands
        "PLN" to "zł",//Poland
        "EUR" to "€",//Portugal
        "QAR" to "ر.ق",//Qatar
        "RON" to "lei",//Romania
        "RUB" to "₽",//Russia
        "RWF" to "Fr",//Rwanda
        "USD" to "$",//Saba
        "DZD" to "د.ج",//Sahrawi Republic
        "MRO" to "UM",//Sahrawi Republic
        "MAD" to "د. م.",//Sahrawi Republic
        "SHP" to "£",//Saint Helena
        "XCD" to "$",//Saint Kitts and Nevis
        "XCD" to "$",//Saint Lucia
        "XCD" to "$",//Saint Vincent and the Grenadines
        "WST" to "T",//Samoa
        "EUR" to "€",//San Marino
        "STD" to "Db",//São Tomé and Príncipe
        "SAR" to "ر.س",//Saudi Arabia
        "XOF" to "Fr",//Senegal
        "RSD" to "din.",//Serbia
        "SCR" to "₨",//Seychelles
        "SLL" to "Le",//Sierra Leone
        "BND" to "$",//Singapore
        "SGD" to "$",//Singapore
        "USD" to "$",//Sint Eustatius
        "ANG" to "ƒ",//Sint Maarten
        "EUR" to "€",//Slovakia
        "EUR" to "€",//Slovenia
        "SBD" to "$",//Solomon Islands
        "SOS" to "Sh",//Somalia
        "ZAR" to "R",//South Africa
        "GBP" to "£",//South Georgia and the South Sandwich Islands
        "RUB" to "₽",//South Ossetia
        "EUR" to "€",//Spain
        "SSP" to "£",//South Sudan
        "LKR" to "රු",//Sri Lanka
        "SDG" to "ج.س.",//Sudan
        "SRD" to "$",//Suriname
        "SZL" to "L",//Swaziland
        "SEK" to "kr",//Sweden
        "CHF" to "Fr",//Switzerland
        "SYP" to "£",//Syria
        "TWD" to "$",//Taiwan
        "TJS" to "ЅМ",//Tajikistan
        "TZS" to "Sh",//Tanzania
        "THB" to "฿",//Thailand
        "XOF" to "Fr",//Togo
        "TOP" to "T$",//Tonga
        "TTD" to "$",//Trinidad and Tobago
        "SHP" to "£",//Tristan da Cunha
        "TND" to "د.ت",//Tunisia
        "TRY" to "₺",//Turkey
        "TMT" to "m",//Turkmenistan
        "USD" to "$",//Turks and Caicos Islands
        "AUD" to "$",//Tuvalu
        "UGX" to "Sh",//Uganda
        "UAH" to "₴",//Ukraine
        "AED" to "د.إ",//United Arab Emirates
        "GBP" to "£",//United Kingdom
        "USD" to "$",//United States
        "UYU" to "$",//Uruguay
        "UZS" to "so'm",//Uzbekistan
        "VUV" to "Vt",//Vanuatu
        "EUR" to "€",//Vatican City
        "VEF" to "Bs F",//Venezuela
        "VND" to "₫",//Vietnam
        "XPF" to "Fr",//Wallis and Futuna
        "YER" to "﷼",//Yemen
        "ZMW" to "ZK",//Zambia
        "BWP" to "P",//Zimbabwe
        "GBP" to "£",//Zimbabwe
        "EUR" to "€",//Zimbabwe
        "INR" to "₹",//Zimbabwe
        "ZAR" to "R",//Zimbabwe
        "USD" to "$",//Zimbabwe
    )
}