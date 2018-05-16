Ext.define('apiDemo.view.main.AccountsSummary', {
    extend: 'Ext.Panel',
    
    requires : [
        'apiDemo.view.main.AccountsSumSearchField',
        'apiDemo.store.DeviceUsageStore'
        ],
    
    xtype: 'accountsSummaryMain',
    
    title : 'Resumen de consumos (Demo)',
    
    layout : 'border',
    
    width: '100%',
    height: 600,
    
    initComponent : function(){
    	
    	var store = Ext.create('apiDemo.store.DeviceUsageStore',{});

    	this.items = [
      	    {
    	    	xtype : 'accountSumSearchField',
    	    	region : 'north',
    	    	height: 100
    	    	,
	    		listeners : {
	    			search : function(info) {
	    				//validar datos completos
	    				
	    				if(!info.accountId){
	    					Ext.Msg.alert('Validation Error ! ', 'Es necesario seleccionar una cuenta !')
	    				}else if (!info.cycleId){
	    					Ext.Msg.alert('Validation Error ! ', 'Es necesario seleccionar un ciclo !')
	    				}else{
	    					store.accountId = info.accountId;
	    					store.cycleId   = info.cycleId;
		    				store.load();
	    				}
	    				
	    				
	    			}
	    		}
    	    	
    	    },
    	    {
    	    	xtype : 'grid',
    	    	
    	    	region : 'center',
    	    		
    	        store: store,

    	        columns: [
    	            { text: 'IccId'   			, dataIndex: 'iccid'    , flex : 2 },
    	            { text: 'Status'  			, dataIndex: 'status'   , flex : 1 },
    	            { text: 'Rate Plan'			, dataIndex: 'ratePlan', flex : 2 },
    	            { text: 'Communication Plan', dataIndex: 'communicationPlan', flex : 2 },
    	            { text: 'Data Usage'		, dataIndex: 'dataUsage', flex : 1 },
    	            { text: 'SMS Usage'			, dataIndex: 'smsUsage', flex : 1 },
    	            { text: 'Vouce Usage'		, dataIndex: 'voiceUsage', flex : 1 },
    	            { text: 'Limit Reached'		, dataIndex: 'overageLimitReached', flex : 1 }
    	            
    	        ],

    	        height: 400,
    	        layout: 'fit',
    	        fullscreen: true

    	    }
        ];
    	
    	this.callParent();
    }
});