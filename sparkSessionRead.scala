import org.apache.spark.sql.SparkSession


object sparkSessionRead {
  def main(args: Array[String]): Unit = {

    /*spark session includes spark sql and hive contexts*/

    val spark = SparkSession.builder
      .appName("Simple Application")
      .master("local")
      // .config("spark.sql.warehouse.dir", "target/spark-warehouse")
      //.enableHiveSupport()
      .getOrCreate

    //spark read
    val myFile = spark.read.csv("src/main/resources/textfile.txt")
    myFile.show()

    //spark read delimited
    val df2 = spark.read.options(Map("delimiter" -> " "))
      .csv("src/main/resources/textfile.txt")
    df2.show()


    //spark read with options
    val df = spark.read.options(Map("inferSchema" -> "true", "delimiter" -> ",", "header" -> "true"))
      .csv("src/main/resources/rita2014jan.csv")
    df.show()
    df.printSchema()

    //create sql view
    df.createOrReplaceTempView("rita")

    //spark sql
    spark.sql("select * from rita")
      .show(false)

  }
  }
