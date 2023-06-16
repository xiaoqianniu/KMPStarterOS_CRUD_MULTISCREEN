package com.lduboscq.appkickstarter

interface FrogRepository {
    suspend fun getFrog(frogName : String): FrogData?
    suspend fun addFrog(frogData : FrogData): FrogData?
    suspend fun deleteFrog(frogName: String): FrogData?
    suspend fun updateFrog(frogName: String): FrogData?
}