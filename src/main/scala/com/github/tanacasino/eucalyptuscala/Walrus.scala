package com.github.tanacasino.eucalyptuscala

import awscala.Credentials
import awscala.s3.{S3, S3Client}


class Walrus(endpoint: String, credentials: Credentials) extends S3Client(credentials) {
  setEndpoint(endpoint)
}


object Walrus extends ROD {
  val Endpoint = "S3_URL"

  def apply(): S3 = {
    val (endpoint, accessKeyId, secretAccessKey) = readOrDie
    apply(endpoint, accessKeyId, secretAccessKey)
  }


  def apply(endpoint: String, accessKeyId: String, secretAccessKey: String): S3 = {
    new Walrus(endpoint, Credentials(accessKeyId,secretAccessKey))
  }
}

