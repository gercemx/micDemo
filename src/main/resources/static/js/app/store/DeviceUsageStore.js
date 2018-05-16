Ext.define('apiDemo.store.DeviceUsageStore',{
	extend : 'Ext.data.JsonStore',
	
	storeId: 'deviceUsageStore',

	model : 'apiDemo.model.DeviceModel',
	
	accountId : null,
	cycleId   : null,
	
	proxy: {
        type: 'ajax',
        reader: {
            type: 'json',
            rootProperty: 'images'
        }
    },

    listeners : {
    	beforeload:function(store, operation){
    		store.proxy.url =
    			'/account/'+store.accountId+'/devices/usage/'+store.cycleId;
    	}
    }

});