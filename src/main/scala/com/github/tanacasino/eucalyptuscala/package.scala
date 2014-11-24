package com.github.tanacasino


package object eucalyptuscala {

  trait ROD {
    def Endpoint: String
    def AccessKeyId: String = "AWS_ACCESS_KEY"
    def SecretAccessKey: String = "AWS_SECRET_KEY"

    // R.O.D!!!
    def readOrDie: (String, String, String) =
      (rod(Endpoint), rod(AccessKeyId), rod(SecretAccessKey))

    private[this] def rod(key: String): String =
      sys.env.getOrElse(key, throw new IllegalStateException(s"Failed to load $key"))
  }

}

