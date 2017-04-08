package algo

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.linalg.{Vector, Vectors}
/**
 * Created by sghipr on 4/7/17.
 */
object Test {
  def main (args: Array[String]): Unit ={
    val conf = new SparkConf().setAppName("SparkTest").setMaster("local")
    val sc = new SparkContext(conf)

    printf("Hello,World!")
  }
}
