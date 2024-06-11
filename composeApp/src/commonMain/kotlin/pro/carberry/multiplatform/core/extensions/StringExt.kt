package pro.carberry.multiplatform.core.extensions

fun String.toUpperCase(isUppercase: Boolean): String = if (isUppercase) this.uppercase() else this
