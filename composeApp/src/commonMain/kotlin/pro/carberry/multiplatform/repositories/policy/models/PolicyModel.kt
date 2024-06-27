package pro.carberry.multiplatform.repositories.policy.models

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString
import pro.carberry.multiplatform.repositories.policy.models.DescriptionSubtitle.None
import pro.carberry.multiplatform.repositories.policy.models.LocalPolicyModel.Description

abstract class PolicyModel(open val title: Any, open val descriptions: Any)

data class RemotePolicyModel(
    override val title: String,
    override val descriptions: String
) : PolicyModel(title, descriptions)

data class LocalPolicyModel(
    override val title: String = "",
    override val descriptions: List<Description>
) : PolicyModel(title, descriptions) {

    data class Description(
        val description: String,
        val offset: Boolean = false,
        val isClickable: Boolean = false,
        val style: PolicyItemStyle? = null,
        val subtitle: DescriptionSubtitle = None
    )
}

suspend fun StringResource.toDescription(): Description {
    return Description(
        description = getString(this),
        offset = false,
        isClickable = false,
        style = null,
        subtitle = None
    )
}

suspend fun StringResource.toDescription(
    args: Any? = null,
    isClickable: Boolean = false,
    subtitle: DescriptionSubtitle = None
): Description {
    val description = args?.let { getString(this, it) } ?: getString(this)
    return Description(description, false, isClickable, null, subtitle)
}

suspend fun StringResource.toDescription(
    offset: Boolean = false,
    isStyled: Boolean = false,
    style: FontWeight = FontWeight.Bold,
    wordCount: Int = 1
): Description {
    val description = getString(this)
    val count = if (wordCount - 1 <= 0) 0 else wordCount - 1
    val styledPart = if (isStyled) getStyledPart(description, count, true) else ""
    val restPart = description.substring(styledPart.length)
    val itemStyle = PolicyItemStyle(text = styledPart, style = SpanStyle(fontWeight = style))
    return Description(restPart, offset, false, itemStyle, None)
}


// TODO need to use ExceptionService
fun String.getWords(count: Int): List<String> = try {
    split(' ').slice(0..count)
} catch (e: IndexOutOfBoundsException) {
    emptyList()
}

fun List<String>.toSingleString(isAddExtraSpace: Boolean): String =
    this.joinToString(separator = " ").let {
        if (it.isEmpty()) return it else it.plus(if (isAddExtraSpace) " " else "")
    }

private fun getStyledPart(description: String, wordCount: Int, isAddExtraSpace: Boolean): String {
    return description.getWords(wordCount).toSingleString(isAddExtraSpace)
}

suspend fun StringResource.mapToString(): String = getString(this)
