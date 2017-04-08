package algo

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{Path, FileSystem}
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by sghipr on 4/8/17.
 */
object WordCount {

  def main (args: Array[String]){

    val conf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)

    val outputFile = "/home/sghipr/sparkTest/wordCount"
    val lines = sc.textFile("/usr/local/spark/README.md")
    val data = lines.flatMap(line => line.split(" "))
    val data2 = data
      .map(t => (t,1))
      .reduceByKey((x,y)=> x+y)

    // if exists,then delete
    val hadoopConf = new Configuration()
    FileSystem.get(hadoopConf).delete(new Path(outputFile),true)

    data2.saveAsTextFile(outputFile)
    printf("Successfully!\n")
    sc.stop()
  }
}
