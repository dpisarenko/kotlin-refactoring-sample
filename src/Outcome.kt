class Outcome<C>(
        val success:Boolean,
        val error:String,
        val result:C? = null
) {
}