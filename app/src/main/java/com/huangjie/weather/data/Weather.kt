package com.huangjie.weather.data

 data class Weather(
    val alerts: List<Any>,
    val aqi: Aqi,
    val brandInfo: BrandInfo,
    val chs: List<Ch>,
    val current: Current,
    val forecastDaily: ForecastDaily,
    val forecastHourly: ForecastHourly,
    val indices: Indices,
    val preHour: List<PreHour>,
    val sourceMaps: SourceMaps,
    val updateTime: Long,
    val url: Url,
    val yesterday: Yesterday
)

data class Aqi(
    val status: Int
)

data class BrandInfo(
    val brands: List<Brand>
)

data class Brand(
    val brandId: String,
    val logo: String,
    val names: Names,
    val url: String
)

data class Names(
    val en_US: String,
    val zh_CN: String,
    val zh_TW: String
)

data class Ch(
    val type: String
)

data class Current(
    val feelsLike: FeelsLike,
    val humidity: Humidity,
    val pressure: Pressure,
    val pubTime: String,
    val temperature: Temperature,
    val uvIndex: String,
    val visibility: Visibility,
    val weather: String,
    val wind: Wind
)

data class FeelsLike(
    val unit: String,
    val value: String
)

data class Humidity(
    val unit: String,
    val value: String
)

data class Pressure(
    val unit: String,
    val value: String
)

data class Temperature(
    val unit: String,
    val value: String
)

data class Visibility(
    val unit: String,
    val value: String
)

data class Wind(
    val direction: Direction,
    val speed: Speed
)

data class Direction(
    val unit: String,
    val value: String
)

data class Speed(
    val unit: String,
    val value: String
)

data class ForecastDaily(
    val aqi: AqiX,
    val precipitationProbability: PrecipitationProbability,
    val pubTime: String,
    val status: Int,
    val sunRiseSet: SunRiseSet,
    val temperature: TemperatureX,
    val weather: WeatherX,
    val wind: WindX
)

data class AqiX(
    val status: Int
)

data class PrecipitationProbability(
    val status: Int,
    val value: List<String>
)

data class SunRiseSet(
    val status: Int,
    val value: List<Value>
)

data class Value(
    val from: String,
    val to: String
)

data class TemperatureX(
    val status: Int,
    val unit: String,
    val value: List<ValueX>
)

data class ValueX(
    val from: String,
    val to: String
)

data class WeatherX(
    val status: Int,
    val value: List<ValueXX>
)

data class ValueXX(
    val from: String,
    val to: String
)

data class WindX(
    val direction: DirectionX,
    val speed: SpeedX
)

data class DirectionX(
    val status: Int,
    val unit: String,
    val value: List<ValueXXX>
)

data class ValueXXX(
    val from: String,
    val to: String
)

data class SpeedX(
    val status: Int,
    val unit: String,
    val value: List<ValueXXXX>
)

data class ValueXXXX(
    val from: String,
    val to: String
)

data class ForecastHourly(
    val aqi: AqiXX,
    val desc: String,
    val status: Int,
    val temperature: TemperatureXX,
    val weather: WeatherXX,
    val wind: WindXX
)

data class AqiXX(
    val status: Int
)

data class TemperatureXX(
    val pubTime: String,
    val status: Int,
    val unit: String,
    val value: List<Int>
)

data class WeatherXX(
    val pubTime: String,
    val status: Int,
    val value: List<Int>
)

data class WindXX(
    val status: Int,
    val value: List<ValueXXXXX>
)

data class ValueXXXXX(
    val datetime: String,
    val direction: String,
    val speed: String
)

data class Indices(
    val indices: List<Indice>,
    val pubTime: String,
    val status: Int
)

data class Indice(
    val type: String,
    val value: String
)

data class PreHour(
    val aqi: AqiXXX,
    val feelsLike: FeelsLikeX,
    val humidity: HumidityX,
    val pressure: PressureX,
    val pubTime: String,
    val temperature: TemperatureXXX,
    val uvIndex: String,
    val visibility: VisibilityX,
    val weather: String,
    val wind: WindXXX
)

data class AqiXXX(
    val aqi: String,
    val brandInfo: BrandInfoX,
    val co: String,
    val coDesc: String,
    val no2: String,
    val no2Desc: String,
    val o3: String,
    val o3Desc: String,
    val pm10: String,
    val pm10Desc: String,
    val pm25: String,
    val pm25Desc: String,
    val primary: String,
    val pubTime: String,
    val so2: String,
    val so2Desc: String,
    val src: String,
    val status: Int,
    val suggest: String
)

data class BrandInfoX(
    val brands: List<BrandX>
)

data class BrandX(
    val brandId: String,
    val logo: String,
    val names: NamesX,
    val url: String
)

data class NamesX(
    val en_US: String,
    val zh_CN: String,
    val zh_TW: String
)

data class FeelsLikeX(
    val unit: String,
    val value: String
)

data class HumidityX(
    val unit: String,
    val value: String
)

data class PressureX(
    val unit: String,
    val value: String
)

data class TemperatureXXX(
    val unit: String,
    val value: String
)

data class VisibilityX(
    val unit: String,
    val value: String
)

data class WindXXX(
    val direction: DirectionXX,
    val speed: SpeedXX
)

data class DirectionXX(
    val unit: String,
    val value: String
)

data class SpeedXX(
    val unit: String,
    val value: String
)

data class SourceMaps(
    val current: CurrentX,
    val daily: Daily,
    val hourly: Hourly
)

data class CurrentX(
    val feelsLike: String,
    val humidity: String,
    val pressure: String,
    val temperature: String,
    val uvIndex: String,
    val weather: String,
    val windSpeed: String
)

data class Daily(
    val aqi: String,
    val preciProbability: String,
    val sunRiseSet: String,
    val temperature: String,
    val weather: String,
    val wind: String
)

data class Hourly(
    val aqi: String,
    val temperature: String,
    val weather: String
)

data class Url(
    val caiyun: String,
    val weathercn: String
)

data class Yesterday(
    val aqi: String,
    val date: String,
    val status: Int,
    val sunRise: String,
    val sunSet: String,
    val tempMax: String,
    val tempMin: String,
    val weatherEnd: String,
    val weatherStart: String,
    val windDircEnd: String,
    val windDircStart: String,
    val windSpeedEnd: String,
    val windSpeedStart: String
)