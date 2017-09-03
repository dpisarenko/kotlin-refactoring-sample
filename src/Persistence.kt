open class Persistence {
    var db:IDatabase? = null

    fun init():Outcome<Boolean> {
        // Initialize the database connection here
        // In case of success, put the database object into this.db
        return Outcome(true, "")
    }
    fun someDatabaseOperation(input:String):Outcome<String> {
        val db = this.db
        if (db == null) {
            // Test case 1
            return Outcome(false, "Internal error")
        }
        try {
            return someDatabaseOperationLogic(db, input) // Test case 2
        }
        catch (exception:Throwable) {
            // Test case 3
            return Outcome(false, exception.message ?: "")
        }
    }

    private fun someDatabaseOperationLogic(db: IDatabase, input: String): Outcome<String> {
        // Do actual operations with the database here
        val result = "Some result"
        return Outcome<String>(true, "", result)
    }
}