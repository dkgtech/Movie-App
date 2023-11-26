package com.dkgtech.movie.model

data class DataModel(
    val data: ArrayList<Data>,
    val message: String,
    val status: Boolean,
    val timestamp: Long
)

data class Data(
    val edges: ArrayList<Edge>,
    val providerName: String
)

data class Edge(
    val title: Title
)

data class CanRateTitle(
    val isRatable: Boolean
)

data class Category(
    val id: String,
    val text: String,
    val value: String
)


data class DisplayableProperty(
    val value: Value
)


data class OriginalTitleText(
    val text: String
)

data class PrimaryImage(
    val id: String,
    val imageHeight: Int,
    val imageUrl: String,
    val imageWidth: Int
)

data class RatingsSummary(
    val aggregateRating: Double,
    val topRanking: TopRanking,
    val voteCount: Int
)

data class ReleaseYear(
    val endYear: Int,
    val year: Int
)

data class Title(
    val canRateTitle: CanRateTitle,
    val id: String,
    val isAdult: Boolean,
    val originalTitleText: OriginalTitleText,
    val primaryImage: PrimaryImage,
    val ratingsSummary: RatingsSummary,
    val releaseYear: ReleaseYear,
    val titleEpisode: Any,
    val titleText: TitleText,
    val titleType: TitleType
)

data class TitleText(
    val text: String
)

data class TitleType(
    val canHaveEpisodes: Boolean,
    val categories: List<Category>,
    val displayableProperty: DisplayableProperty,
    val id: String,
    val isEpisode: Boolean,
    val isSeries: Boolean,
    val text: String
)

data class TopRanking(
    val rank: Int
)

data class Value(
    val plainText: String
)

data class WatchOptionsByCategory(
    val categorizedWatchOptionsList: List<CategorizedWatchOptionsList>,
)

data class CategorizedWatchOptionsList(
    val watchOptions: List<WatchOption>,
)

data class WatchOption(
    val provider: Provider,
    val title: Title,
    val description: Description2,
    val shortDescription: ShortDescription?,
    val link: String,
)

data class Provider(
    val id: String,
    val categoryType: String,
    val description: Description?,
    val name: Name,
    val refTagFragment: String,
    val logos: Logos,
)

data class Description(
    val value: String,
)

data class Name(
    val value: String,
)

data class Logos(
    val icon: Icon,
    val slate: Slate,
)

data class Icon(
    val url: String,
    val width: Long,
    val height: Long,
)

data class Slate(
    val url: String,
    val width: Long,
    val height: Long,
)

data class Description2(
    val value: String,
)

data class ShortDescription(
    val value: String,
)

data class Plot(
    val id: String,
    val author: Any?,
    val plotText: PlotText,
    val correctionLink: CorrectionLink,
    val reportingLink: ReportingLink,
)

data class PlotText(
    val plainText: String,
)

data class CorrectionLink(
    val url: String,
)

data class ReportingLink(
    val url: String,
)

data class ReleaseDate(
    val day: Long,
    val month: Long,
    val year: Long,
    val country: Country,
    val restriction: Any?,
    val releaseAttributes: List<ReleaseAttribute>,
)

data class Country(
    val id: String,
    val text: String,
)

data class ReleaseAttribute(
    val text: String,
)

data class TitleCertificate(
    val rating: String,
    val certificateCountry: CertificateCountry,
    val ratingReason: String?,
)

data class CertificateCountry(
    val id: String,
    val text: String,
)

data class TitleRuntime(
    val seconds: Long,
    val displayableProperty: DisplayableProperty2,
)

data class DisplayableProperty2(
    val qualifiersInMarkdownList: List<QualifiersInMarkdownList>?,
)

data class QualifiersInMarkdownList(
    val plainText: String,
)

data class ChartMeterRanking(
    val currentRank: Long,
    val rankChange: RankChange,
)

data class RankChange(
    val changeDirection: String,
    val difference: Long,
)