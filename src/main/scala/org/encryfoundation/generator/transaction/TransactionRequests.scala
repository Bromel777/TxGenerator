package org.encryfoundation.generator.transaction

import io.circe.{Decoder, HCursor}

case class PaymentTransactionRequest(fee: Long, amount: Long, recipient: String)

object PaymentTransactionRequest {

  implicit val jsonDecoder: Decoder[PaymentTransactionRequest] = (c: HCursor) => {
    for {
      fee <- c.downField("fee").as[Long]
      amount <- c.downField("amount").as[Long]
      rec <- c.downField("recipient").as[String]
    } yield PaymentTransactionRequest(fee, amount, rec)
  }
}

case class ScriptedTransactionRequest(fee: Long, amount: Long, source: String)

object ScriptedTransactionRequest {

  implicit val jsonDecoder: Decoder[ScriptedTransactionRequest] = (c: HCursor) => {
    for {
      fee <- c.downField("fee").as[Long]
      amount <- c.downField("amount").as[Long]
      script <- c.downField("script").as[String]
    } yield ScriptedTransactionRequest(fee, amount, script)
  }
}

case class AssetIssuingTransactionRequest(fee: Long, amount: Long, source: String)
