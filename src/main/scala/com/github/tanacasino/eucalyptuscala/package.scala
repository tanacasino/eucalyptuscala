package com.github.tanacasino


package object eucalyptuscala {

  trait ROD {
    val Endpoint: String
    val AccessKeyId: String = "AWS_ACCESS_KEY"
    val SecretAccessKey: String = "AWS_SECRET_KEY"

    // R.O.D!!!
    def readOrDie: (String, String, String) =
      (rod(Endpoint), rod(AccessKeyId), rod(SecretAccessKey))

    private[this] def rod(key: String): String =
      sys.env.getOrElse(key, throw new IllegalStateException(s"Failed to load $key"))
  }

}

