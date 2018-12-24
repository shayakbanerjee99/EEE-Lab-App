package com.example.shayak.eeelabapp

/**
 * Experiment contains data about the experiment. It will be used by ExperimentActivity to
 * load data from the materialLink and will also be used for launching the video in the local
 * media player.
 *
 * @author Shayak Banerjee
 * @version 1.0
 * @since 23rd Dec, 2018
 */
data class Experiment(val experimentName: String, val materialLink: String, val videoLink: String){

}