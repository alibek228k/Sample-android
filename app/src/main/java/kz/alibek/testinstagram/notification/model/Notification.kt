package kz.alibek.testinstagram.notification.model

sealed class Notification(open val profileImageUrl: String, open val username: String) {
    data class Like(
        override val username: String,
        override val profileImageUrl: String
    ) : Notification(profileImageUrl, username)

    data class Comment(
        override val username: String,
        override val profileImageUrl: String
    ) : Notification(profileImageUrl, username)

    data class MightKnow(
        override val username: String,
        override val profileImageUrl: String
    ) : Notification(profileImageUrl, username)

    companion object {
        val exampleList = listOf(
            Like(
                username = "ali250432",
                profileImageUrl = "https://img.freepik.com/free-photo/androgynous-avatar-non-binary-queer-person_23-2151100270.jpg?size=338&ext=jpg&ga=GA1.1.2113030492.1729382400&semt=ais_hybrid",
            ),
            Comment(
                username = "erzhan_zheter",
                profileImageUrl = "https://png.pngtree.com/png-vector/20220807/ourmid/pngtree-man-avatar-wearing-gray-suit-png-image_6102786.png",
            ),
            MightKnow(
                username = "erzhan_zheter",
                profileImageUrl = "https://png.pngtree.com/png-vector/20220807/ourmid/pngtree-man-avatar-wearing-gray-suit-png-image_6102786.png",
            ),
            Like(
                username = "erkebulan",
                profileImageUrl = "https://img.freepik.com/free-psd/3d-illustration-person-with-sunglasses_23-2149436188.jpg?size=338&ext=jpg&ga=GA1.1.2113030492.1729382400&semt=ais_hybrid",
            ),
            Like(
                username = "Nazym",
                profileImageUrl = "https://metricool.com/wp-content/uploads/Screen-Shot-2023-06-28-at-2.21.12-PM.png",
            ),
            Comment(
                username = "azamat",
                profileImageUrl = "https://img.freepik.com/free-psd/3d-illustration-human-avatar-profile_23-2150671142.jpg?size=338&ext=jpg&ga=GA1.1.2113030492.1729382400&semt=ais_hybrid",
            ),
            MightKnow(
                username = "Asel",
                profileImageUrl = "https://static.vecteezy.com/system/resources/thumbnails/004/899/680/small_2x/beautiful-blonde-woman-with-makeup-avatar-for-a-beauty-salon-illustration-in-the-cartoon-style-vector.jpg",
            ),
            Like(
                username = "Daniyal",
                profileImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsvlZwNYheldpgbYr4eBHXwX-uvSHfAyPgXw&s",
            ),
            Comment(
                username = "azamat",
                profileImageUrl = "https://img.freepik.com/free-psd/3d-illustration-human-avatar-profile_23-2150671142.jpg?size=338&ext=jpg&ga=GA1.1.2113030492.1729382400&semt=ais_hybrid",
            ),
            MightKnow(
                username = "Asel",
                profileImageUrl = "https://static.vecteezy.com/system/resources/thumbnails/004/899/680/small_2x/beautiful-blonde-woman-with-makeup-avatar-for-a-beauty-salon-illustration-in-the-cartoon-style-vector.jpg",
            ),
        )
    }
}
