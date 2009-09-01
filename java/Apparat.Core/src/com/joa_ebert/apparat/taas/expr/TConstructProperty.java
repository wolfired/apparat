/*
 * This file is part of Apparat.
 * 
 * Apparat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Apparat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Apparat. If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (C) 2009 Joa Ebert
 * http://www.joa-ebert.com/
 * 
 */

package com.joa_ebert.apparat.taas.expr;

import com.joa_ebert.apparat.abc.AbcEnvironment;
import com.joa_ebert.apparat.abc.MethodBody;
import com.joa_ebert.apparat.abc.bytecode.Bytecode;
import com.joa_ebert.apparat.abc.bytecode.operations.ConstructProp;
import com.joa_ebert.apparat.taas.TaasReference;
import com.joa_ebert.apparat.taas.TaasValue;
import com.joa_ebert.apparat.taas.constants.TaasMultiname;

/**
 * 
 * @author Joa Ebert
 * 
 */
public class TConstructProperty extends TConstruct
{
	@TaasReference
	public TaasMultiname property;

	public TConstructProperty( final TaasValue object,
			final TaasMultiname property, final TaasValue[] parameters )
	{
		super( object, parameters, property.getType() );

		this.property = property;
	}

	@Override
	protected void emitOps( final AbcEnvironment environment,
			final MethodBody body, final Bytecode code )
	{
		object.emit( environment, body, code );
		emitParams( environment, body, code );
		code.add( new ConstructProp( parameters.length, property.multiname ) );
	}

	@Override
	public String toString()
	{
		return "[TConstructProperty " + object.toString() + ", "
				+ property.toString() + "]";
	}
}