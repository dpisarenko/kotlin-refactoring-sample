class Persistence2 {
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
        return processErrors { someDatabaseOperationLogic(db, input) }
    }

    fun <C>processErrors(logic: () -> Outcome<C>):Outcome<C> {
        try {
            return logic() // Test case 2
        }
        catch (exception:Throwable) {
            return Outcome(false, exception.message ?: "") // Test case 2
        }
    }

    private fun someDatabaseOperationLogic(db: IDatabase, input: String): Outcome<String> {
        // Do actual operations with the database here
        val result = "Some result"
        return Outcome<String>(true, "", result)
    }
}