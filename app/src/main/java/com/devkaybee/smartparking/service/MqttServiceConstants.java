/*******************************************************************************
 * Copyright (c) 1999, 2016 IBM Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution. 
 *
 * The Eclipse Public License is available at 
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 */
package com.devkaybee.smartparking.service;

import org.eclipse.paho.android.service.MqttService;

/**
 * Various strings used to identify operations or data in the Android MQTT
 * service, mainly used in Intents passed between Activities and the Service.
 */
interface MqttServiceConstants {

	/*
	 * Version information
	 */
	
	String VERSION = "v0";
	
  /*
   * Attributes of messages <p> Used for the column names in the database
   */
  String DUPLICATE = "duplicate";
  String RETAINED = "retained";
  String QOS = "qos";
  String PAYLOAD = "payload";
  String DESTINATION_NAME = "destinationName";
  String CLIENT_HANDLE = "clientHandle";
  String MESSAGE_ID = "messageId";

  /* Tags for actions passed between the Activity and the Service */
  String SEND_ACTION = "send";
  String UNSUBSCRIBE_ACTION = "unsubscribe";
  String SUBSCRIBE_ACTION = "subscribe";
  String DISCONNECT_ACTION = "disconnect";
  String CONNECT_ACTION = "connect";
  String CONNECT_EXTENDED_ACTION = "connectExtended";
  String MESSAGE_ARRIVED_ACTION = "messageArrived";
  String MESSAGE_DELIVERED_ACTION = "messageDelivered";
  String ON_CONNECTION_LOST_ACTION = "onConnectionLost";
  String TRACE_ACTION = "trace";

  /* Identifies an Intent which calls back to the Activity */
  String CALLBACK_TO_ACTIVITY = org.eclipse.paho.android.service.MqttService.TAG
                                             + ".callbackToActivity"+"."+VERSION;

  /* Identifiers for extra data on Intents broadcast to the Activity */
  String CALLBACK_ACTION = org.eclipse.paho.android.service.MqttService.TAG + ".callbackAction";
  String CALLBACK_STATUS = org.eclipse.paho.android.service.MqttService.TAG + ".callbackStatus";
  String CALLBACK_CLIENT_HANDLE = org.eclipse.paho.android.service.MqttService.TAG + "."
                                               + CLIENT_HANDLE;
  String CALLBACK_ERROR_MESSAGE = org.eclipse.paho.android.service.MqttService.TAG
                                               + ".errorMessage";
  String CALLBACK_EXCEPTION_STACK = org.eclipse.paho.android.service.MqttService.TAG
                                                 + ".exceptionStack";
  String CALLBACK_INVOCATION_CONTEXT = org.eclipse.paho.android.service.MqttService.TAG + "."
                                                    + "invocationContext";
  String CALLBACK_ACTIVITY_TOKEN = org.eclipse.paho.android.service.MqttService.TAG + "."
                                                + "activityToken";
  String CALLBACK_DESTINATION_NAME = org.eclipse.paho.android.service.MqttService.TAG + '.'
                                                  + DESTINATION_NAME;
  String CALLBACK_MESSAGE_ID = org.eclipse.paho.android.service.MqttService.TAG + '.'
                                            + MESSAGE_ID;
  String CALLBACK_RECONNECT = org.eclipse.paho.android.service.MqttService.TAG + ".reconnect";
  String CALLBACK_SERVER_URI = org.eclipse.paho.android.service.MqttService.TAG + ".serverURI";
  String CALLBACK_MESSAGE_PARCEL = org.eclipse.paho.android.service.MqttService.TAG + ".PARCEL";
  String CALLBACK_TRACE_SEVERITY = org.eclipse.paho.android.service.MqttService.TAG
                                                + ".traceSeverity";
  String CALLBACK_TRACE_TAG = org.eclipse.paho.android.service.MqttService.TAG + ".traceTag";
  String CALLBACK_TRACE_ID = org.eclipse.paho.android.service.MqttService.TAG + ".traceId";
  String CALLBACK_ERROR_NUMBER = org.eclipse.paho.android.service.MqttService.TAG
                                              + ".ERROR_NUMBER";

  String CALLBACK_EXCEPTION = org.eclipse.paho.android.service.MqttService.TAG + ".exception";
  
  //Intent prefix for Ping sender.
  String PING_SENDER = org.eclipse.paho.android.service.MqttService.TAG + ".pingSender.";
  
  //Constant for wakelock
  String PING_WAKELOCK = org.eclipse.paho.android.service.MqttService.TAG + ".client.";
  String WAKELOCK_NETWORK_INTENT = MqttService.TAG + "";

  //Trace severity levels  
  String TRACE_ERROR = "error";
  String TRACE_DEBUG = "debug";
  String TRACE_EXCEPTION = "exception";
  
  
  //exception code for non MqttExceptions
  int NON_MQTT_EXCEPTION = -1;

}