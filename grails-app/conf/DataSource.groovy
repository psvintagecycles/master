dataSource {
//    pooled = true
//	configClass=org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration.class
//    driverClassName = 'com.mysql.jdbc.Driver'
//	url = 'jdbc:mysql://p3plcpnl0276.prod.phx3.secureserver.net/pstest'
//    username = "pstest"
//    password = "pstest"
//	dialect = org.hibernate.dialect.MySQL5InnoDBDialect
//	logSql = true
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			    pooled = true
				configClass=org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration.class
			    driverClassName = 'com.mysql.jdbc.Driver'
				url = 'jdbc:mysql://p3plcpnl0276.prod.phx3.secureserver.net/ptest'
			    username = "ptest"
			    password = "ptest"
				dialect = org.hibernate.dialect.MySQL5InnoDBDialect
				loggingSql = false
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            configClass=org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration.class
			    driverClassName = 'com.mysql.jdbc.Driver'
				url = 'jdbc:mysql://p3plcpnl0276.prod.phx3.secureserver.net/psvintagecycles'
			    username = "web_user"
			    password = "n2v6yg0"
				dialect = org.hibernate.dialect.MySQL5InnoDBDialect
				loggingSql = false
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
