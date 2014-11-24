package com.github.tanacasino.eucalyptuscala

import awscala.Credentials
import awscala.ec2.{EC2Client, EC2}


class Eucalyptus(endpoint: String, credentials: Credentials) extends EC2Client(credentials) {
  setEndpoint(endpoint)
}


object Eucalyptus extends ROD {
  val Endpoint: String = "EC2_URL"

  def apply(): EC2 = {
    val (endpoint, accessKeyId, secretAccessKey) = readOrDie
    apply(endpoint, accessKeyId, secretAccessKey)
  }


  def apply(endpoint: String, accessKeyId: String, secretAccessKey: String): EC2 = {
    new Eucalyptus(endpoint, Credentials(accessKeyId, secretAccessKey))
  }
}

