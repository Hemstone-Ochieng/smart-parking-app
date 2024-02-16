package com.devkaybee.smartparking.data.mqtt

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devkaybee.smartparking.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage

class MattViewModel: ViewModel() {

    lateinit var mqttClient: MqttAndroidClient
    private val serverURL ="tcp://13.60.36.20:1883"
    private val tag = "MqttClient"


    private var slotCOHES = MutableLiveData<String>()
    private var slotAssembly = MutableLiveData<String>()
    private var slotHall = MutableLiveData<String>()
    private var slotHospital = MutableLiveData<String>()
    private var slotIEET = MutableLiveData<String>()

    fun monitorCOHES(): LiveData<String>{
        return slotCOHES
    }

    fun monitorAssembly(): LiveData<String>{
        return slotAssembly
    }

    fun monitorHall(): LiveData<String>{
        return slotHall
    }

    fun monitorHospital(): LiveData<String>{
        return slotHospital
    }

    fun monitorIEET(): LiveData<String>{
        return slotIEET
    }




    fun connect(context: Context){
        mqttClient = MqttAndroidClient(
            context,
            serverURL,
            "Adafruit"
        )
        mqttClient.setCallback(object: MqttCallbackExtended {
            override fun connectionLost(cause: Throwable?) {
                displayLog("Connection Lost!")
            }

            override fun messageArrived(topic: String?, message: MqttMessage?) {
                val messagePayload = String(message!!.payload)
                when(topic){
                    "slot/cohes" -> slotCOHES.value = messagePayload
                    "slot/assembly" -> slotAssembly.value = messagePayload
                    "slot/technology" -> slotHall.value = messagePayload
                    "slot/jhospital"-> slotHospital.value = messagePayload
                    "slot/ieet"-> slotIEET.value = messagePayload

                    else -> println("Unknown Channel")
                }

            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                displayLog("Delivered")
            }

            override fun connectComplete(reconnect: Boolean, serverURI: String?) {
                displayLog("Connected!")
            }

        })

        try {
            mqttClient.connect(serverOptions(),null,object: IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    mqttClient.setBufferOpts(disconnectedBufferOptions())
                    subscribe("slot/cohes")
                    subscribe("slot/assembly")
                    subscribe("slot/technology")
                    subscribe("slot/jhospital")
                    subscribe("slot/ieet")
                    //  displayLog("Connected to Broker!")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    displayLog("Failed to connect!")
                }

            })

        } catch (e: MqttException){
            e.printStackTrace()
        }
    }

    fun subscribe(topic: String,qos: Int =1){
        mqttClient.subscribe(topic,qos,null,object: IMqttActionListener {
            override fun onSuccess(asyncActionToken: IMqttToken?) {
                //displayLog("Subscribed!")
            }

            override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                displayLog("Failed to subscribe")
            }

        })
    }

    fun publish(topic: String, msg: String, qos: Int, retained: Boolean = false){
        val message = MqttMessage()
        message.payload = msg.toByteArray()
        message.qos = qos
        message.isRetained = retained

        try {
            mqttClient.publish(topic,message,null, object: IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    displayLog("Published to $topic")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    displayLog("Failed to publish")
                }

            })
        } catch (e: MqttException){
            e.printStackTrace()
        }
    }

    private fun disconnect(){
        try {
            mqttClient.disconnect(null,object: IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    displayLog("Disconnected!")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    displayLog("Failed to Disconnect!")
                }

            })

        } catch (e: MqttException){
            e.printStackTrace()
        }
    }

    private fun serverOptions(): MqttConnectOptions {
        return MqttConnectOptions().apply {
            isAutomaticReconnect = true
            isCleanSession = false
        }
    }

    private fun disconnectedBufferOptions(): DisconnectedBufferOptions {
        return DisconnectedBufferOptions().apply {
            isBufferEnabled = true
            bufferSize =100
            isPersistBuffer = false
            isDeleteOldestMessages = false
        }
    }

    private fun displayLog(message: String){
        Log.d(tag, message)
    }


}