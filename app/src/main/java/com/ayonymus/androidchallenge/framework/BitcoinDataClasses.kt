package com.ayonymus.androidchallenge.framework

/**
 * Auto generated from json response with the Json To Kotlin Class plugin
 * https://github.com/wuseal/JsonToKotlinClass
 *
 * Field names could be annotated to have better naming. However, since I introduced
 * entities in the domain layer, I do not feel necessary to make any improvemnets.
 *
 * Suppress annotations are present because of Detekt.
 */

@Suppress("ConstructorParameterNaming")
data class BlockchainResponse (
    val addresses: List<Addresse>,
    val info: Info,
    val recommend_include_fee: Boolean,
    val txs: List<Tx>,
    val wallet: Wallet
)


@Suppress("ConstructorParameterNaming")
data class Wallet(
    val final_balance: Long,
    val n_tx: Int,
    val n_tx_filtered: Int,
    val total_received: Long,
    val total_sent: Long
)


@Suppress("ConstructorParameterNaming")
data class Info(
    val conversion: Int,
    val latest_block: LatestBlock,
    val nconnected: Int,
    val symbol_btc: SymbolBtc,
    val symbol_local: SymbolLocal
)

@Suppress("ConstructorParameterNaming")
data class SymbolLocal(
    val code: String,
    val conversion: Double,
    val local: Boolean,
    val name: String,
    val symbol: String,
    val symbolAppearsAfter: Boolean
)

@Suppress("ConstructorParameterNaming")
data class SymbolBtc(
    val code: String,
    val conversion: Double,
    val local: Boolean,
    val name: String,
    val symbol: String,
    val symbolAppearsAfter: Boolean
)

@Suppress("ConstructorParameterNaming")
data class LatestBlock(
    val block_index: Int,
    val hash: String,
    val height: Int,
    val time: Long
)

@Suppress("ConstructorParameterNaming")
data class Addresse(
    val account_index: Int,
    val address: String,
    val change_index: Int,
    val final_balance: Long,
    val n_tx: Int,
    val total_received: Int,
    val total_sent: Int
)

@Suppress("ConstructorParameterNaming")
data class Tx(
    val `out`: List<Out>,       // an array of outputs of the transaction
    val balance: Long,          // current balance of xPub address
    val block_height: Int,
    val block_index: Int,
    val double_spend: Boolean,
    val fee: Long,              // total fee of transaction
    val hash: String,           // identifier of transaction
    val inputs: List<Input>,
    val lock_time: Long,
    val relayed_by: String,
    val result: Long,           // amount sent to or from address
    val size: Int,
    val time: Long,              // timestamp of transaction
    val tx_index: Int,
    val ver: Int,
    val vin_sz: Int,
    val vout_sz: Int,
    val weight: Int
)

@Suppress("ConstructorParameterNaming")
data class Input(
    val index: Int,
    val prev: Prev,
    val prev_out: PrevOut,
    val script: String,
    val sequence: Long,
    val witness: String,
    val xpub: XpubX
)

@Suppress("ConstructorParameterNaming")
data class Xpub(
    val m: String,
    val path: String
)

@Suppress("ConstructorParameterNaming")
data class PrevOut(
    val addr: String,
    val n: Int,
    val script: String,
    val spending_outpoints: List<SpendingOutpointX>,
    val spent: Boolean,
    val tx_index: Int,
    val type: Int,
    val value: Long,
    val xpub: Xpub
)

@Suppress("ConstructorParameterNaming")
data class SpendingOutpoint(
    val n: Int,
    val tx_index: Int
)

@Suppress("ConstructorParameterNaming")
data class Prev(
    val addr: String,
    val n: Int,
    val script: String,
    val spending_outpoints: List<SpendingOutpoint>,
    val spent: Boolean,
    val tx_index: Int,
    val type: Int,
    val value: Long,
    val xpub: Xpub
)

@Suppress("ConstructorParameterNaming")
data class Out(
    val addr: String,
    val n: Int,
    val script: String,
    val spending_outpoints: List<SpendingOutpoint>,
    val spent: Boolean,
    val tx_index: Int,
    val type: Int,
    val value: Long,
    val xpub: Xpub
)

@Suppress("ConstructorParameterNaming")
data class XpubX(
    val m: String,
    val path: String
)

@Suppress("ConstructorParameterNaming")
data class SpendingOutpointX(
    val n: Int,
    val tx_index: Int
)
