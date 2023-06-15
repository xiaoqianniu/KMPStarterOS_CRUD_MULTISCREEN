package com.lduboscq.appkickstarter.main

import com.lduboscq.appkickstarter.Frog
import io.realm.kotlin.Realm
import io.realm.kotlin.types.RealmUUID

abstract class UserRepositoryRealm : UserRepository {

    lateinit var realm: Realm

    abstract suspend fun setupRealmSync()

    suspend fun convertToUserData(user: User?): UserData? {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }

        var userData: UserData? = null
        realm.write {
            if (user != null) {
                userData = UserData(
                    id = user!!._id,
                    username = user!!.username,
                    email = user!!.email,
                    password = user!!.password,
                    confirmPassword = user!!.confirmPassword,
                    user = user,
                )
            }
        }
        return userData

    }

    private fun closeRealmSync() {
        realm.close()
    }

    override suspend fun getUser(
        userName: String,
        email: String,
        password: String,
        confirmPassword: String
    ): UserData? {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        val user: User? = realm.query<User>(User::class, "username = \"$userName\"").first().find()
        return convertToUserData(user)
    }

    override suspend fun addUser(userData: UserData): UserData? {
        if (!this::realm.isInitialized) {
            setupRealmSync()
        }
        var newUser: User? = null
        realm.write {
            newUser = this.copyToRealm(User().apply {
                _id = userData.id ?: RealmUUID.random().toString()
                username = userData.username
                email = userData.email
                password = userData.password
                confirmPassword = userData.confirmPassword
            })
        }

        return convertToUserData(newUser)
    }
}