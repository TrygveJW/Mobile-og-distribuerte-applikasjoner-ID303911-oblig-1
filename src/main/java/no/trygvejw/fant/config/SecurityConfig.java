/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.trygvejw.fant.config;

import javax.annotation.security.DeclareRoles;
import javax.annotation.sql.DataSourceDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import no.ntnu.tollefsen.auth.Group;
import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 * @author trygve
 */
@DataSourceDefinition(
        name = "java:global/jdbc/DemoDataSource",
        className = "org.postgresql.ds.PGSimpleDataSource",
        serverName = "postgres_db",  // set the property
        portNumber = 5432,        // set the property
        databaseName = "local_db",    // set the property
        user = "test",
        password = "test123")
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:global/jdbc/DemoDataSource",
        callerQuery="select password from auser where userid = ?",
        groupsQuery="select name from ausergroup where userid  = ?",
        hashAlgorithm = PasswordHash.class,
        priority = 80)
@DeclareRoles({Group.ADMIN,Group.USER})
@LoginConfig(authMethod = "MP-JWT",realmName = "template")
public class SecurityConfig {



}
