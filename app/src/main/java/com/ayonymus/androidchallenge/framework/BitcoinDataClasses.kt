package com.ayonymus.androidchallenge.framework

/**
 * Auto generated from json response with the Json To Kotlin Class plugin
 * https://github.com/wuseal/JsonToKotlinClass
 */
data class BlockchainResponse (
    val addresses: List<Addresse>,
    val info: Info,
    val recommend_include_fee: Boolean,
    val txs: List<Tx>,
    val wallet: Wallet
)

data class Info(
    val conversion: Double,
    val latest_block: LatestBlock,
    val nconnected: Int,
    val symbol_btc: SymbolBtc,
    val symbol_local: SymbolLocal
)

data class SymbolBtc(
    val code: String,
    val conversion: Double,
    val local: Boolean,
    val name: String,
    val symbol: String,
    val symbolAppearsAfter: Boolean
)

data class SymbolLocal(
    val code: String,
    val conversion: Double,
    val local: Boolean,
    val name: String,
    val symbol: String,
    val symbolAppearsAfter: Boolean
)

data class LatestBlock(
    val block_index: Int,
    val hash: String,
    val height: Int,
    val time: Int
)

data class Wallet(
    val final_balance: Int,
    val n_tx: Int,
    val n_tx_filtered: Int,
    val total_received: Int,
    val total_sent: Int
)

data class Tx(
    val `out`: List<Out>,
    val balance: Int,
    val block_height: Int,
    val double_spend: Boolean,
    val fee: Int,
    val hash: String,
    val inputs: List<Input>,
    val lock_time: Int,
    val relayed_by: String,
    val result: Int,
    val size: Int,
    val time: Int,
    val tx_index: Int,
    val ver: Int,
    val vin_sz: Int,
    val vout_sz: Int,
    val weight: Int
)

data class Input(
    val prev_out: PrevOut,
    val script: String,
    val sequence: Long,
    val witness: String
)

data class PrevOut(
    val addr: String,
    val n: Int,
    val script: String,
    val spent: Boolean,
    val tx_index: Int,
    val type: Int,
    val value: Int,
    val xpub: Xpub
)

data class Xpub(
    val m: String,
    val path: String
)

data class Out(
    val addr: String,
    val n: Int,
    val script: String,
    val spent: Boolean,
    val tx_index: Int,
    val type: Int,
    val value: Int,
    val xpub: XpubX
)

data class XpubX(
    val m: String,
    val path: String
)

data class Addresse(
    val account_index: Int,
    val address: String,
    val change_index: Int,
    val final_balance: Int,
    val gap_limit: Int,
    val n_tx: Int,
    val total_received: Int,
    val total_sent: Int
)