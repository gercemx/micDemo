Ext.define('apiDemo.model.DeviceModel',{
	extend : 'Ext.data.Model',
	
	fields : [
	    {name: 'iccid'				,  type: 'string'},
	    {name: 'status'				,  type: 'string'},
	    {name: 'ratePlan'			,  type: 'string'},
	    {name: 'communicationPlan'	,  type: 'string'},
	    {name: 'dataUsage'			,  type: 'int'},
	    {name: 'smsUsage'			,  type: 'int'},
	    {name: 'voiceUsage'			,  type: 'int'},
	    {name: 'overageLimitReached',  type: 'boolean'}
	    
	]
});