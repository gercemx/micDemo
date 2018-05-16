Ext.define('apiDemo.view.main.AccountsSumSearchField', {
    extend: 'Ext.form.Panel',
    xtype: 'accountSumSearchField',
    
    requires: [
        'apiDemo.store.Accounts',
        'apiDemo.store.Cycle'
    ],
    
    layout : 'hbox',
    
    initComponent : function(){
    	var me = this;
    	
    	me.accountId  = null;
    	me.cycleId    = null;
    	
    	me.accountIdCB = {
    		xtype : 'combobox',
	    	fieldLabel : 'Account',
	    	displayField: 'accountId',
	        valueField  : 'accountId',
	        flex : 1,
	    	store : Ext.create('apiDemo.store.Accounts',{}),
	    	listeners : {
	    		select : function(combo, record){
	    			me.accountId = this.getValue();
	    		}
	    	}
    	};
    	
    	me.items = [
      	    me.accountIdCB,
    	    {
    	    	xtype       : 'combobox',
    	    	fieldLabel  : 'Ciclo',
    	    	queryMode   : 'local',
    	        displayField: 'name',
    	        editable : false,
    	        flex : 2,
    	        
    	        valueField  : 'id',
                store: Ext.create('apiDemo.store.Cycle',{}),
    	    	listeners : {
    	    		select : function(combo, record){
    	    			me.cycleId = this.getValue();
    	    		}
    	    	}
    	    },
    	    {
    	    	xtype : 'button',
    	    	text : 'Buscar',
    	    	listeners: {
    	    		click : function(){
    	    			me.fireEvent('search',{ accountId : me.accountId, cycleId : me.cycleId});
    	    		}
    	    	}
    	    }
        ];
    	
    	this.callParent();
    }
});