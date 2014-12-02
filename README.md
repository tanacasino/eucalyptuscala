# eucalyptuscala #

Call Eucalyptus API on Scala REPL.

Require JRE 1.7 or later.


## How to use

```
# source your eucarc
$ source eucarc

# clone eucalyptuscala
$ git clone https://github.com/tanacasino/eucalyptuscala.git
$ cd eucalyptuscala

# Run REPL
$ ./bin/sbt console
scala> import com.github.tanacasino.eucalyptuscala._
import com.github.tanacasino.eucalyptuscala._

scala> implicit val euca = Eucalyptus()
euca: awscala.ec2.EC2 = com.github.tanacasino.eucalyptuscala.Eucalyptus@36240cb7

scala> euca.instances
res0: Seq[awscala.ec2.Instance] = ArrayBuffer()

scala> euca.instances.filter(_.name.startsWith("euca-")).map(_.instanceId)
res1: Seq[String] = ArrayBuffer()

scala> implicit val walrus = Walrus()
walrus: awscala.s3.S3 = com.github.tanacasino.eucalyptuscala.Walrus@542d8f6d

scala> val mybucket = walrus.createBucket("mybucket")
mybucket: awscala.s3.Bucket = S3Bucket [name=mybucket, creationDate=null, owner=null]

scala> mybucket.keys
res3: Seq[String] = Stream()

scala> mybucket.put
put   putAsPublicRead   putAsPublicReadWrite   putObject   putObjectAsPublicRead   putObjectAsPublicReadWrite

scala> mybucket.putObject

def putObject(key: String, bytes: Array[Byte], metadata: com.amazonaws.services.s3.model.ObjectMetadata)(implicit s3: S3): PutObjectResult
def putObject(key: String, file: java.io.File)(implicit s3: S3): PutObjectResult

scala> val obj = mybucket.putObject("hoge.txt", new java.io.File("/home/tanacasino/hoge.txt"))
obj: awscala.s3.PutObjectResult = PutObjectResult(S3Bucket [name=mybucket, creationDate=null, owner=null],hoge.txt,null,4a3b564e9d8e78ac0cca5e6e0c0b3258,SjtWTp2OeKwMyl5uDAsyWA==,2014-11-24T21:35:23.180+09:00,null,null)

scala> walrus.buckets.foreach(println)
S3Bucket [name=loadbalancer-v1, creationDate=Mon Nov 24 15:44:02 JST 2014, owner=S3Owner [name=eucalyptus,id=351c014a473cb1b3c3d10364c35c3d3e39241e1f41535a2639391c5b20552c19]]
S3Bucket [name=mybucket, creationDate=Mon Nov 24 21:18:41 JST 2014, owner=S3Owner [name=eucalyptus,id=351c014a473cb1b3c3d10364c35c3d3e39241e1f41535a2639391c5b20552c19]]
S3Bucket [name=test001, creationDate=Mon Nov 24 20:57:32 JST 2014, owner=S3Owner [name=eucalyptus,id=351c014a473cb1b3c3d10364c35c3d3e39241e1f41535a2639391c5b20552c19]]
```


## Dependencies

- Java (1.7 or later)
- AWScala
- aws-sdk-java

